package dao;

import pojos.Course;

public interface ICourseDao {

	// add new method to insert new course details
	String lauchNewCourse(Course transientCourse);

	// add a new method to delete a course
	String cancelCourse(int courseId);

	Course displayCourseDetails(String courseTitle);

}
