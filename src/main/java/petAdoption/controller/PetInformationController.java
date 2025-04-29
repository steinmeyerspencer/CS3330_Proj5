package petAdoption.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import com.google.gson.reflect.TypeToken;

import petAdoption.model.Shelter;
import petAdoption.model.ShelterModel;
import petAdoption.pet.Pet;
import petAdoption.views.AddPetView;
import petAdoption.views.PetListView;

public class PetInformationController {
	
	private ShelterModel shelterModel;
//	private AddPetView addPetView;
	private PetListView petListView;
    private DefaultListModel<Pet> sharedModel;

	
	public PetInformationController() {
	
		Shelter<Pet> shelter = new Shelter<Pet>();
		
		Type adoptablePetListType = new TypeToken<ArrayList<Pet>>() {}.getType();
		shelter.readInPets("src/main/resources/pets.json",adoptablePetListType);
		List<Pet> adoptablePets = shelter.getPetList();
		System.out.println(adoptablePets);
		
		ShelterModel model = new ShelterModel();
	
		for (Pet pet : shelter.getPetList()) {
		    model.addPet(pet);
		}
		
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
	        int selectedIndex = petListView.getSelectedPet();
	        petListView.getPetList().remove(selectedIndex); 
            shelterModel.getPetList().remove(selectedIndex);
		}
		
	}
	
	
}
