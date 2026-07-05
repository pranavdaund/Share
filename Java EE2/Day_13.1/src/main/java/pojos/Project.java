package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project extends BasedEntity {

	@Column(name = "ProjectTitle", length = 120, unique = true)
	private String projectTitle;

	@Column(name = "Technology", length = 120)
	private String technology;

	@Column(name = "Date")
	private LocalDate completionDate;

	// many to many uni direction
	// Project * ---> *Student
	@ManyToMany
	@JoinTable(name = "Projects_Students", joinColumns = @JoinColumn(name = "ProjectId"), inverseJoinColumns = @JoinColumn(name = "StudentId"))
	private Set<Student> students = new HashSet<>();

	public Project() {

	}

	public Project(String projectTitle, String technology, LocalDate completionDate) {
		super();
		this.projectTitle = projectTitle;
		this.technology = technology;
		this.completionDate = completionDate;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Project [ Id()=" + getId() + ", projectTitle=" + projectTitle + ", technology=" + technology
				+ ", completionDate=" + completionDate + "]";
	}

}
