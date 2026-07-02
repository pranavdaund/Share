package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// courses Table columns: id, title, start_date, end_date, fees, capacity

@Entity
@Table(name = "Course")
public class Course extends BasedEntity {

	@Column(name = "title", length = 30, unique = true)
	private String title;

	@Column(name = "StartDate")
	private LocalDate startDate;

	@Column(name = "EndDate")
	private LocalDate endDate;

	@Column(name = "fees")
	private double fees;

	@Column(name = "capacity")
	private int capacity;

	// if u want to establish one ---> many association(HAS - A) between course n
	// student, do you
	// need to add any additional property? YES
	// Course 1 ----> * Student

	@OneToMany(mappedBy = "chosenCourse", cascade = CascadeType.ALL, orphanRemoval = true/* , fetch = FetchType.EAGER */)
	private List<Student> students = new ArrayList<Student>(); // ALWAYS init Collection to empty Collection.

	public Course() {

	}

	public Course(String title, LocalDate startDate, LocalDate endDate, Double fees, Integer capacity) {
		// super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.capacity = capacity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;

	}

	// suggestion from the founder : add helper methods : establishing the link is
	// is it mandatory : NO Optional But recomm

	public void addStudent(Student s) {
		// add student ref in the Course
		students.add(s);
		// assign course ref to the student
		s.setChosenCourse(this);

	}

	public void removeStudent(Student s) {
		// remove student ref from the course
		students.remove(s);
		// remove course ref from the Student
		s.setChosenCourse(null);
	}

	// TIP: NEVER ADD Association fields (eg: student) in to String

	@Override
	public String toString() {
		return "Course Id " + getId() + " [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fees=" + fees + ", capacity=" + capacity + "]";
	}

}