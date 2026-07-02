package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends BasedEntity {

	@Column(name = "City", length = 20)
	private String city;

	@Column(name = "State", length = 30)
	private String state;

	@Column(name = "Country", length = 30)
	private String country;

	@Column(name = "ZipCode", length = 20)
	private String zipCode;

	// one to one association : uni dir manner
	// Address 1 ---> 1 Student
	@OneToOne
	@JoinColumn(name = "Student_Id", nullable = false)
	@MapsId
	private Student student;

	public Address() {

	}

	public Address(String city, String state, String country, String zipCode) {
		this.city = city;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [id= " + getId() + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + "]";
	}

}
