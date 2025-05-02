package petAdoption.petModels;

public class ExoticAnimal{
	
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private Integer yearsOld;
	
	
	
	
	/**
	 * Do not need constructors for ExoticAnimal class, it will be wrapped inside of an adapter that extends Pet
	 */
	
	
	
	/**
	 * Getter for uniqueID
	 * @return
	 */
	
	public String getUniqueID() {
		return uniqueId;
	}
	
	/**
	 * Setter for uniqueID
	 * @param uniqueID
	 */
	public void setUniqueID(String uniqueID) {
		this.uniqueId = uniqueID;
	}
	
	
	/**
	 * Getter for animalName
	 * @return
	 */
	public String getAnimalName() {
		return animalName;
	}
	
	/**
	 * Setter for animalName
	 * @param animalName
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	
	
	/**
	 * Getter for category
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Setter for category
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	/**
	 * getter for subSpecies
	 * @return
	 */
	public String getSubSpecies() {
		return subSpecies;
	}
	
	/**
	 * Setter for subSpecies
	 * @param subSpecies
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}
	
	
	
	/**
	 * Getter for yearsOld
	 * @return
	 */
	public Integer getYearsOld() {
		return yearsOld;
	}
	
	/**
	 * Setter for yearsOld
	 * @param yearsOld
	 */
	public void setYearsOld(Integer yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	
	
}