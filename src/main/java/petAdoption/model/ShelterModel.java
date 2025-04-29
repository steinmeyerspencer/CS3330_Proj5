package petAdoption.model;

import java.util.ArrayList;
import java.util.List;

import petAdoption.pet.Pet;

public class ShelterModel {
	
	private List<Pet> petList;
	
	public ShelterModel() {
		petList = new ArrayList<>();
	}
	
	/**
	 * add a pet object to the list
	 * @param pet
	 */
	public void addPet(Pet pet) {
		this.petList.add(pet);
	}
	
	/**
	 * generic getter for petList
	 * @return
	 */
	public List<Pet> getPetList(){
		return this.petList;
	}
}
