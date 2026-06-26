package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;
import pojos.Course;

public class GetCourseAndStudentsDetails {

	public static void main(String[] args) {
		CourseDaoImp dao = new CourseDaoImp();

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter the Course title");
			String title = sc.next();
			Course c = dao.displayCourseDetails(title);

			System.out.println("Course details" + c);
			System.out.println("Student enrolled for course " + c.getTitle());
			c.getStudents().forEach(System.out::println);

//			System.out.println(c);

		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}