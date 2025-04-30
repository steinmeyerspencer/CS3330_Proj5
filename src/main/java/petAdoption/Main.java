package petAdoption;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.google.gson.reflect.TypeToken;

import petAdoption.controller.PetInformationController;
import petAdoption.model.Shelter;
import petAdoption.model.ShelterModel;
import petAdoption.petModels.AdoptablePet;
import petAdoption.petModels.Pet;
import petAdoption.views.PetListView;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				//instantiate controller
				PetInformationController controller = new PetInformationController();
				
				controller.initiate();
				
			}
			
		});
		
		
	}

}
