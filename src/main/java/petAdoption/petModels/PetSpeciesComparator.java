package petAdoption.petModels;

import java.util.Comparator;

public class PetSpeciesComparator implements Comparator<Pet>{

	@Override
	public int compare(Pet p1, Pet p2) {
		if (p1.getSpecies() == null && p2.getSpecies() == null) return 0;
		if (p1.getSpecies() == null) return -1;
		if (p2.getSpecies() == null) return 1;
		return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
	}

}
