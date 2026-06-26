package dao;

import pojos.Student;

public interface IStudentDao {

	// add a new method for student admission
	String admitNewStudent(Student s, String courseName);

	// add a method to cancel student admission
	String cancelAdmission(String courseName, int studentId);

}
