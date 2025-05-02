package petAdoption.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.reflect.TypeToken;

import petAdoption.model.ExoticAnimalLoader;
import petAdoption.model.Shelter;
import petAdoption.model.ShelterModel;
import petAdoption.petModels.AdoptablePet;
import petAdoption.petModels.ExoticAnimalAdapter;
import petAdoption.petModels.Pet;
import petAdoption.views.AddPetDialog;
import petAdoption.views.PetListView;

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
	 * when adopt button clicked, if pet is selected, is 
	 */
	private class AdoptButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet selected = petListView.getSelectedPet();
			if(selected != null && !selected.isAdopted() && selected.isAdoptable()) {
				selected.setAdopted(true);
				petListView.repaint();
			}
		}
		
	}
	
	
	// NEED TO DO
	private class SaveButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// save list (shelterModel.getPetList()) to JSON file
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
			    JOptionPane.showMessageDialog(petListView,
			    	"ID: " + selected.getId() +
			        "\nName: " + selected.getName() +
			        "\nAge: " + selected.getAge() +
			        "\nType: " + selected.getType() +
			        "\nSpecies: " + selected.getSpecies() + 
			        "\nAdopted: " + selected.isAdopted(),
			        "Pet Details",
			        JOptionPane.INFORMATION_MESSAGE
			    );
			}
		}
	}
	
}
