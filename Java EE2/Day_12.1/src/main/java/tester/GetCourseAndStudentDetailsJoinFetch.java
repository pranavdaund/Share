package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;
import pojos.Course;

public class GetCourseAndStudentDetailsJoinFetch {

	public static void main(String[] args) {
		CourseDaoImp dao = new CourseDaoImp();

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter the Course title");
			String title = sc.next();

			// used fetch annotation
			// Course c = dao.displayCourseDetails(title);

			Course c = dao.getCourseAndStudentDetailsJoinfetch(title);

			System.out.println("Course details \n" + c + "\n");
			System.out.println("Student enrolled for course " + c.getTitle());

			c.getStudents().forEach(System.out::println);

			// trying to access fetched data from outside session context.

		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}