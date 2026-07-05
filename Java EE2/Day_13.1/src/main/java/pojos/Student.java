package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//students Table columns: id, name, email + Foreign Key (FK): course_id
//student : many side of the association child side, owning side(will contain later FK ---> referencing to pk of Course)
@Entity
@Table(name = "student")
public class Student extends BasedEntity {

	@Column(name = "name", length = 20)
	private String name;

	@Column(name = "email", length = 50, unique = true)
	private String email;

	// what's should to the additional prop for mapping a bi directional
	// association, so that
	// one can find out chosen course's details from student?
	// Course 1 <--------- * Student

	@ManyToOne()
	@JoinColumn(name = "course_id", nullable = false) // NOT NULL Constraint
	private Course chosenCourse;

	public Student() {

	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Course getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	@Override
	public String toString() {
		return "Student id: " + getId() + ", [name=" + name + ", email=" + email + "]";
	}

}