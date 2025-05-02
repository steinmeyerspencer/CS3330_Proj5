package petAdoption.petModels;

public class ExoticAnimalAdapter extends Pet{
	
	// i dont think we need this
//	private ExoticAnimal exoticAnimal;
	
	
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
//		this.exoticAnimal = exoticAnimal;
		super(exoticAnimal.getUniqueID(),
				exoticAnimal.getAnimalName(),
				exoticAnimal.getCategory(),
				exoticAnimal.getSubSpecies(),
				exoticAnimal.getYearsOld()
				);
		
//		super.setId(exoticAnimal.getUniqueID());
//		super.setName(exoticAnimal.getAnimalName());
//		super.setType(exoticAnimal.getCategory());
//		super.setSpecies(exoticAnimal.getSubSpecies());
//		super.setAge(exoticAnimal.getYearsOld());
		
		
	}
	

	@Override
	public boolean isAdoptable() {
		return false;
	}

}
