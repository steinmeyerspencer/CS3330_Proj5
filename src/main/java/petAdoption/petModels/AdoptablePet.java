package petAdoption.petModels;

public class AdoptablePet extends Pet{
	
	private boolean adopted;
	
	/**
	 * non - parameterized constructor
	 */
	public AdoptablePet() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * includes adoption status
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 */
	public AdoptablePet(String id, String name, String type, String species, Integer age, boolean adopted) {
		super(id,name,type,species,age);
		this.adopted = adopted;
	}

	/**
	 * regular getter for adoptable status
	 * always true because is adoptablePet
	 */
	public boolean isAdoptable() {
		return true;
	}

	/**
	 * regular getter for adoption status
	 * @return
	 */
	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * sets adoption status
	 * @param adopted
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
}
