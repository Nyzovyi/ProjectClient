package ua.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes={@Index(columnList = "name")})
public class Street {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	private City city;
	@OneToMany(mappedBy="street")   // Звязки !!!!!!!!!!!!!!!!!!!!!!
	List<Adress> address;
	

	public Street() {
		
	}

	public Street(int id, String name, City city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Adress> getAddress() {
		return address;
	}

	public void setAddress(List<Adress> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	
	
	
}
