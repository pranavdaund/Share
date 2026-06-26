package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;
import pojos.Course;

public class GetCourseDetails {

	public static void main(String[] args) {
		CourseDaoImp dao = new CourseDaoImp();

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter the Course title");

			String title = sc.next();

			Course c = dao.displayCourseDetails(title);
			System.out.println(c);

		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}