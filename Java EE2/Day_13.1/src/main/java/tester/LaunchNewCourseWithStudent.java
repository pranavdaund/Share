package tester;

import static java.time.LocalDate.parse;
import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;
import pojos.Course;
import pojos.Student;

public class LaunchNewCourseWithStudent {

	public static void main(String[] args) {
		CourseDaoImp dao = new CourseDaoImp();
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter the Course Details: title, startDate, endDate, fees, capacity");

			Course c = new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt());

			for (int i = 0; i < 3; i++) {
				System.out.println("Enter Student details: name, email");
				Student s1 = new Student(sc.next(), sc.next());
				c.addStudent(s1);
			}
			String updateinfo = dao.lauchNewCourse(c);
			System.out.println(updateinfo);
		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}