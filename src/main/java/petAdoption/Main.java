package petAdoption;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import petAdoption.pet.AdoptablePet;
import petAdoption.readfiles.Shelter;

public class Main {

	public static void main(String[] args) {
		Shelter petConverter = new Shelter();
		
		Type adoptablePetListType = new TypeToken<ArrayList<AdoptablePet>>() {}.getType();
		List<AdoptablePet> adoptablePets = petConverter.readInPets("src/main/resources/pets.json",adoptablePetListType);
		System.out.println(adoptablePets);
		
		
		
	}

}
