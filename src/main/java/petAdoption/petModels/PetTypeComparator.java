package petAdoption.petModels;

import java.util.Comparator;

public class PetTypeComparator implements Comparator<Pet>{

	@Override
	public int compare(Pet p1, Pet p2) {
		if (p1.getType() == null && p2.getType() == null) return 0;
        if (p1.getType() == null) return -1;
        if (p2.getType() == null) return 1;
        return p1.getType().compareToIgnoreCase(p2.getType());
	}

}
