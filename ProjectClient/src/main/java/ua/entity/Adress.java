package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(indexes={@Index(columnList = "namberHouse")})
public class Adress {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)	
	private Street street;
	
	private int namberHouse;

	
	
	public Adress() {
		
	}

	public Adress(int id, Street street, int namberHouse) {
		super();
		this.id = id;
		this.street = street;
		this.namberHouse = namberHouse;
	}

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

	public int getNamberHouse() {
		return namberHouse;
	}

	public void setNamberHouse(int namberHouse) {
		this.namberHouse = namberHouse;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", street=" + street + ", namberHouse="
				+ namberHouse + "]";
	}

		
	
		
}
