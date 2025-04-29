package petAdoption.pet;

public class ExoticAnimal extends Pet{
	
	/*
	 * 
	 *   {
    "uniqueId": "exo001",
    "animalName": "Zazu",
    "category": "Bird",
    "subSpecies": "Toucan",
    "yearsOld": 4
  },*/
	
	private String uniqueID;
	private String animalName;
	private String category;
	private String subSpecies;
	private Integer yearsOld;
	
	public Integer changeUniqueIdToInteger(String uniqueID) {
		String intPartOfID = uniqueID.replace("exo", "");
		Integer integerID = 1000 + Integer.parseInt(intPartOfID);
		return integerID;
	}
	
	/**
	 * non-parameterized constructor
	 */
	public ExoticAnimal() {
		super();
		this.setAdoptable(false);
	}

	/**
	 * parameterized constructor, changes uniqueID from exo00_ to 100_
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 */
	public ExoticAnimal(String uniqueID, String animalName, String category, String subSpecies, Integer yearsOld) {
		super(changeUniqueIdToInteger(uniqueID), animalName, category, subspecies, yearsold);
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
