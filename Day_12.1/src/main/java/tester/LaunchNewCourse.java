package tester;

import static java.time.LocalDate.parse;
import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;
import pojos.Course;

public class LaunchNewCourse {

	public static void main(String[] args) {
		CourseDaoImp dao = new CourseDaoImp();
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter the Course Details: title, startDate, endDate, fees, capacity");

			String updateinfo = dao.lauchNewCourse(
					new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt()));

			System.out.println(updateinfo);
		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}