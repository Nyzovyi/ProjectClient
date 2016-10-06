package ua.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String lastName;
	@ManyToOne(fetch=FetchType.LAZY)
	private Name name;
	
	private String surname;
	@ManyToOne(fetch=FetchType.LAZY)
	private Adress adress;
//	@Temporal(TemporalType.DATE)
	@Column(length=10)
	private Date dateOfBirth;
	
	private String phone;
	
	private String path;
	
	private int version;
		
	public Client() {
	}
	
	public Client(int id, String lastName, Name name, String surname,
			Adress adress, Date dateOfBirth, String phone) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.name = name;
		this.surname = surname;
		this.adress = adress;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastName=" + lastName + ", name=" + name
				+ ", surname=" + surname + ", adress=" + adress
				+ ", dateOfBirth=" + dateOfBirth + ", phone=" + phone
				+ ", path=" + path + ", version=" + version + "]";
	}

	


	
	
}
