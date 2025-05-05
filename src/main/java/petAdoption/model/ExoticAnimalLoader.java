package petAdoption.model;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.io.Reader;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petAdoption.petModels.ExoticAnimal;
import petAdoption.petModels.ExoticAnimalAdapter;

import java.util.ArrayList;


public class ExoticAnimalLoader {
	public static List<ExoticAnimalAdapter> loadFromJson(String filePath) {
		try {
			Gson gson = new Gson();
			Reader reader = new FileReader(filePath);
			Type exoticType = new TypeToken<List<ExoticAnimal>>() {}.getType();
			
			List<ExoticAnimal> rawExotics = gson.fromJson(reader, exoticType);
						
			List<ExoticAnimalAdapter> wrapped = new ArrayList<>();
			for (ExoticAnimal ea : rawExotics) {
				wrapped.add(new ExoticAnimalAdapter(ea));
			}
			
			return wrapped;
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
