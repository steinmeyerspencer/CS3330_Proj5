package petAdoption.petModels;

public abstract class Pet implements Comparable<Pet>{
	

	private String id;
	private String name;
	private String type;
	private String species;
	private Integer age;
	public abstract boolean isAdoptable();
	
	/**
	 * parameterized constructor
	 * @param id
	 * @param name
	 * @param type
	 * @param species
	 * @param age
	 * @param adopted
	 */
	public Pet(String id, String name, String type, String species, Integer age) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.species = species;
        this.age = age;
    }
	
	/**
	 * non parameterized constructor
	 */
	public Pet() {}
	
	
	/**
	 * regular getter
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * regular setter
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * regular toString
	 */
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ "]";
	}

	/**
	 * regular getter
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * regular setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * regular getter
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * regular setter
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * regular getter
	 * @return
	 */
	public String getSpecies() {
		return species;
	}
	
	/**
	 * regular setter
	 * @param species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	
	/**
	 * regular getter
	 * @return
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * regular setter
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
	/**
	 * Comparable implementation
	 */
	@Override
	public int compareTo(Pet other) {
		if (this.name == null && other.name == null) return 0;
		if (this.name == null) return -1;
		if (other.name == null) return 1;
		return this.name.compareToIgnoreCase(other.name);
	}
	

}
