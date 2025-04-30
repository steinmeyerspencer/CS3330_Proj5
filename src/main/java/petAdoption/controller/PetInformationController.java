package petAdoption.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.reflect.TypeToken;

import petAdoption.model.Shelter;
import petAdoption.model.ShelterModel;
import petAdoption.petModels.AdoptablePet;
import petAdoption.petModels.Pet;
import petAdoption.views.AddPetView;
import petAdoption.views.PetListView;

public class PetInformationController {
	
	private ShelterModel shelterModel;
//	private AddPetView addPetView;
	private PetListView petListView;
    private DefaultListModel<Pet> sharedModel;

	
	public PetInformationController() {
	
		// set up shelter and read in pets
		Shelter<Pet> shelter = new Shelter<Pet>();
		Type adoptablePetListType = new TypeToken<ArrayList<AdoptablePet>>() {}.getType();
		shelter.readInPets("src/main/resources/pets.json",adoptablePetListType);
		//NEED TO READ IN EXOTIC PETS WHEN ADAPTER IS WORKING
		
//		List<Pet> adoptablePets = shelter.getPetList();
//		System.out.println(adoptablePets);
		
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
	    this.petListView.addActionListenerToDeleteUserButton(new DeleteUserButtonActionListener());
	    
	    // add listener to view
	    petListView.addActionListenerToViewPetButton(new ViewSelectedPetInformation());

		
	}
	
	/**
	 * set the list to visible
	 */
	public void initiate() {
		petListView.setVisible(true);
	}
	
	
	private class DeleteUserButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
	        int selectedIndex = petListView.getSelectedPetIndex();
	        sharedModel.remove(selectedIndex); 
	        shelterModel.getPetList().remove(selectedIndex);
		}
		
	}
	
	
	/**
	 * class for the actionListener that will be implemented for the viewButton
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
