package petAdoption.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import petAdoption.model.ExoticAnimalLoader;
import petAdoption.model.Shelter;
import petAdoption.model.ShelterModel;
import petAdoption.petModels.AdoptablePet;
import petAdoption.petModels.ExoticAnimal;
import petAdoption.petModels.ExoticAnimalAdapter;
import petAdoption.petModels.Pet;
import petAdoption.views.AddPetDialog;
import petAdoption.views.PetListView;
import petAdoption.petModels.PetAgeComparator;
import petAdoption.petModels.PetSpeciesComparator;
import petAdoption.petModels.PetTypeComparator;

import java.io.Writer;
import java.io.FileWriter;

public class PetInformationController {
	
	private ShelterModel shelterModel;
//	private AddPetView addPetView;
	private PetListView petListView;
    private DefaultListModel<Pet> sharedModel;

	
    /**
     * non parameterized constructor
     * sets up shelter, 
     * reads in pets from json files
     * adds pets from files to Shelter and ShelterModel
     * creates GUI, links the lists
     */
	public PetInformationController() {
	
		// set up shelter and read in pets
		Shelter<Pet> shelter = new Shelter<Pet>();
		
		
		// Load adoptable pets
		Type adoptablePetListType = new TypeToken<ArrayList<AdoptablePet>>() {}.getType();
		shelter.readInPets("src/main/resources/pets.json",adoptablePetListType);
		
		// load exotic pets
//		Type exoticAnimalListType = new TypeToken<ArrayList<ExoticAnimalAdapter>>() {}.getType();
//		shelter.readInPets("src/main/resources/exotic_animals.json", exoticAnimalListType);
		
		/**
		 * Load and wrap the exotic animals using the helper class
		 * 
		 */
		List<ExoticAnimalAdapter> exoticWrapped = ExoticAnimalLoader.loadFromJson("src/main/resources/exotic_animals.json");
		shelter.getPetList().addAll(exoticWrapped);
		
		// add pets to shelterModel
		this.shelterModel = new ShelterModel();
		for (Pet pet : shelter.getPetList()) {
		    this.shelterModel.addPet(pet);
		}
		
		// make and fill shared model
		this.sharedModel = new DefaultListModel<>();
	    for (Pet pet : this.shelterModel.getPetList()) {
	        sharedModel.addElement(pet);
	    }
	    
	    // create GUI, link the list
	    this.petListView = new PetListView(sharedModel);
	    
	    
	    // add listeners to view
	    this.petListView.addActionListenerToDeleteUserButton(new DeletePetButtonActionListener());
	    this.petListView.addActionListenerToViewPetButton(new ViewSelectedPetInformation());
	    this.petListView.addActionListenerToAddPetButton(new AddButtonActionListener());
	    this.petListView.addActionListenerToAdoptButton(new AdoptButtonActionListener());
	    this.petListView.addActionListenerToSaveButton(new SaveButtonActionListener());
	    
	    
	    /**
	     * Add sorting logic to the sorting combo box
	     */
	    this.petListView.getComboBox().addActionListener(e -> {
	    	String selected = (String) this.petListView.getComboBox().getSelectedItem();
	    	
	    	// Copy model to a temporary list
	    	List<Pet> pets = Collections.list(this.sharedModel.elements());
	    	
	    	switch (selected) {
	    		case "Sort by Name":
	    			Collections.sort(pets);
	    			break;
	    		case "Sort by Age":
	    			Collections.sort(pets, new PetAgeComparator());
	    			break;
	    		case "Sort by Type":
	    			Collections.sort(pets, new PetTypeComparator());
	    			break;
	    		case "Sort by Species":
	    			Collections.sort(pets, new PetSpeciesComparator());
	    			break;
	    		
	    	}
	    	
	    	this.sharedModel.clear();
	    	for (Pet pet: pets) {
	    		this.sharedModel.addElement(pet);
	    	}
	    	
	    });
	    

		
	}
	
	/**
	 * set the list to visible
	 */
	public void initiate() {
		petListView.setVisible(true);
	}
	
	
	/**
	 * action listener for deleteButton
	 */
	private class DeletePetButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
	        int selectedIndex = petListView.getSelectedPetIndex();
	        if (selectedIndex != -1) {
		        sharedModel.remove(selectedIndex); 
		        shelterModel.getPetList().remove(selectedIndex);
				JOptionPane.showMessageDialog(petListView, "Pet deleted successfully", "Pet Deleted", JOptionPane.INFORMATION_MESSAGE);
	        }
			else {
				JOptionPane.showMessageDialog(petListView, "Please select a pet","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
	/**
	 * adds action listener to the submit button inside the Add dialog
	 */
	private class AddPetSubmitButtonActionListener implements ActionListener{
	    private AddPetDialog dialog;
	    public AddPetSubmitButtonActionListener(AddPetDialog dialog) {
	        this.dialog = dialog;
	    }
		@Override
		public void actionPerformed(ActionEvent e) {			
			// pull from pet form
	        try {
	        	String id = dialog.getIDInput();
	            String name = dialog.getNameInput();
	            String type = dialog.getTypeInput();
	            String species = dialog.getSpeciesInput();
	            Integer age = dialog.getAgeInput();
	            boolean adopted = dialog.getAdoptedInput();

	         // make into a Pet
	            Pet newPet = new AdoptablePet(id,name,type,species,age,adopted);
	            sharedModel.addElement(newPet);
	            shelterModel.addPet(newPet);
	            dialog.dispose();
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(dialog, "Please enter a valid number for age.");
	        }
		}
	}
	
	/**
	 * when add button on home page is clicked, opens dialog, sets submit button action listener
	 */
	private class AddButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AddPetDialog dialog = new AddPetDialog(petListView);
	        dialog.addSubmitListener(new AddPetSubmitButtonActionListener(dialog));
	        dialog.showDialog();
		}
		
	}
	
	/**
	 * when adopt button clicked, checks three things 
	 * 1 if pet is selected
	 * 2 if pet is adoptable
	 * 3 if pet is already adopted
	 * pops up error messages if any of the 3 not true, sets adopted to true if all 3 passes 
	 */
	private class AdoptButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet rawSelected = petListView.getSelectedPet();
			int selectedIndex = petListView.getSelectedPetIndex();
			if(rawSelected != null ) {
				// only even try if the pet is an adoptablePet
				if(rawSelected instanceof AdoptablePet) {
					AdoptablePet selected = (AdoptablePet) rawSelected;
					if (!selected.isAdopted()) {
						selected.setAdopted(true);
						sharedModel.set(selectedIndex,selected);
						JOptionPane.showMessageDialog(petListView, "Congrats on your new pet!", "Pet Adopted!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(petListView, "Pet has already been adopted", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(petListView, "Pet is not adoptable","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(petListView, "Please select a pet","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
	// NEED TO DO
	private class SaveButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Create List of pets that copies same list from current model
			List<Pet> petsToSave = shelterModel.getPetList();
			
			
			// Create timestamped filename
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
	        String formattedDateTime = now.format(formatter);
	        String filename = "src/main/resources/" + formattedDateTime + "_pets.json";
	        
	        
	        try (Writer writer = new FileWriter(filename)) {
	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
	            gson.toJson(petsToSave, writer);
	            JOptionPane.showMessageDialog(petListView, "Pets saved successfully to:\n" + filename, "Save Complete", JOptionPane.INFORMATION_MESSAGE);
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(petListView, "Error saving pets: " + ex.getMessage(), "Save Failed", JOptionPane.ERROR_MESSAGE);
	        }
		}
		
	}
	
	
	/**
	 *	actionListener for viewButton
	 * when view button is clicked, displays the pet's information in a JOption Pane that is a pop-up
	 */
	private class ViewSelectedPetInformation implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Pet selected = petListView.getSelectedPet();
			
			
			if (selected != null) {
				// check if pet is adoptable, if so, display the adopted status also
				String isAdopted = "";
				if(selected instanceof AdoptablePet) {
					boolean isAdoptedBool = ((AdoptablePet) selected).isAdopted();
					isAdopted = "\nAdopted: " + isAdoptedBool;
				}
			    JOptionPane.showMessageDialog(petListView,
			    	"ID: " + selected.getId() +
			        "\nName: " + selected.getName() +
			        "\nAge: " + selected.getAge() +
			        "\nType: " + selected.getType() +
			        "\nSpecies: " + selected.getSpecies() + 
			        isAdopted,
			        "Pet Details",
			        JOptionPane.INFORMATION_MESSAGE
			    );
			}
			else {
				JOptionPane.showMessageDialog(petListView, "Please select a pet","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
