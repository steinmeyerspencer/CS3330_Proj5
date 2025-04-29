package petAdoption;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import petAdoption.pet.AdoptablePet;
import petAdoption.shelter.Shelter;

public class Main {

	public static void main(String[] args) {
		
		Shelter<AdoptablePet> petConverter = new Shelter<AdoptablePet>();
		
		Type adoptablePetListType = new TypeToken<ArrayList<AdoptablePet>>() {}.getType();
		petConverter.readInPets("src/main/resources/pets.json",adoptablePetListType);
		List<AdoptablePet> adoptablePets = petConverter.getPetList();
		System.out.println(adoptablePets);
		
		
		
	}

}
