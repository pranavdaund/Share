package dao;

import pojos.Course;

public interface ICourseDao {

	// add new method to insert new course details
	String lauchNewCourse(Course transientCourse);

	// add a new method to delete a course
	String cancelCourse(int courseId);

	// add a new method to get ONLY course details
	Course displayCourseDetails(String courseTitle);

	// add a new method to get course as well as enrolled student details
	Course getCourseAndStudentDetails(String title);

	// add a new method to get course + enrolled student details : using join fetch
	Course getCourseAndStudentDetailsJoinfetch(String title);
}