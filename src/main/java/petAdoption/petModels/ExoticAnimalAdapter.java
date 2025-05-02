package petAdoption.petModels;

public class ExoticAnimalAdapter extends Pet{
	
	private ExoticAnimal exoticAnimal;
	
	
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		this.exoticAnimal = exoticAnimal;
		
		super.setId(exoticAnimal.getUniqueID());
		super.setName(exoticAnimal.getAnimalName());
		super.setType(exoticAnimal.getCategory());
		super.setSpecies(exoticAnimal.getSubSpecies());
		super.setAge(exoticAnimal.getYearsOld());
		super.setAdopted(false);
		
		
	}
	

	@Override
	public boolean isAdoptable() {
		// TODO Auto-generated method stub
		return false;
	}

}
