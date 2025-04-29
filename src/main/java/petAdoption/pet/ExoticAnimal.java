package petAdoption.pet;

public class ExoticAnimal extends Pet{
	
	private boolean adoptable;
	
	/**
	 * non-parameterized constructor
	 */
	public ExoticAnimal() {
		super();
		this.adoptable = false;
	}

	/**
	 * parameterized constructor
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 */
	public ExoticAnimal(Integer id, String name, String type, String species, Integer age, boolean adopted) {
//		super(id,name,type,species,age,adopted);
		this.adoptable = false;
	}

	/**
	 * regular getter
	 * @return
	 */
	public boolean isAdoptable() {
		return adoptable;
	}

	/**
	 * regular setter
	 * @param adoptable
	 */
	public void setAdoptable(boolean adoptable) {
		this.adoptable = adoptable;
	}

	/**
	 * regular toString
	 */
	@Override
	public String toString() {
		return super.toString() + ", ExoticAnimal [adoptable=" + adoptable + "]";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdopted() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
