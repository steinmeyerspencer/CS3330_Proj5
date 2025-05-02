package petAdoption.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petAdoption.petModels.AdoptablePet;
import petAdoption.petModels.Pet;

public class Shelter<T extends Pet> {
	
	private Gson gson;
	private List<T> petList;
	
	/**
	 * non - parameterized constructor
	 */
	public Shelter() {
		this.gson = new Gson();
		petList = new ArrayList();
	}
	
	/**
	 * reads in pets file, returns list of Pets
	 * takes filepath and Type as parameters and returns list of Pets
	 */
	public void readInPets(String filepath, Type type) {	
		try{
			Scanner fileInput = new Scanner(new FileInputStream(filepath));
            StringBuilder jsonContent = new StringBuilder();
            while (fileInput.hasNextLine()) {
                jsonContent.append(fileInput.nextLine());
            }
            fileInput.close();
            
            List<T> loadedPets = gson.fromJson(jsonContent.toString(), type);
            
            this.petList.addAll(loadedPets);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        
	}
	
	/**
	 * generic getter for petList
	 * @return
	 */
	public List<T> getPetList(){
		return this.petList;
	}
	
	

	
}

