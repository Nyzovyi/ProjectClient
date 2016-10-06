package ua.form;

import ua.entity.Street;

public class AdressForm {

	private int id;
	
	private Street street;
	
	private String namberHouse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getNamberHouse() {
		return namberHouse;
	}

	public void setNamberHouse(String namberHouse) {
		this.namberHouse = namberHouse;
	}
	
}
