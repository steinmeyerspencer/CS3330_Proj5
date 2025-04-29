package petAdoption.readfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petAdoption.pet.AdoptablePet;
import petAdoption.pet.Pet;

public class Shelter<T extends Pet> {
	
	private Gson gson;
	
	/**
	 * non - parameterized constructor
	 */
	public Shelter() {
		this.gson = new Gson();
	}
	
	/**
	 * reads in pets file, returns list of Pets
	 * takes filepath and Type as parameters and returns list of Pets
	 */
	public List<T> readInPets(String filepath, Type type) {	
		List<T> petList = new ArrayList<>();
		
		try{
			Scanner fileInput = new Scanner(new FileInputStream(filepath));
            StringBuilder jsonContent = new StringBuilder();
            while (fileInput.hasNextLine()) {
                jsonContent.append(fileInput.nextLine());
            }
            fileInput.close();
            
            petList = gson.fromJson(jsonContent.toString(), type);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return petList;
	}
		
		

	
}

