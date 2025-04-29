package petAdoption.pet;

public abstract class Pet {
	private Integer id;
	private String name;
	private String type;
	private String species;
	private Integer age;
	private boolean adopted;
	
	/**
	 * regular getter
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * regular setter
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * regular toString
	 */
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
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
	 * regular getter
	 * @return
	 */
	public boolean isAdopted() {
		return adopted;
	}
	
	/**
	 * regular setter
	 * @param adopted
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	
}
