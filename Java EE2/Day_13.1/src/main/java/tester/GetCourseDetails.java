package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;
import pojos.Course;

public class GetCourseDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			System.out.println("hibernate up and running !" + sf);
			CourseDaoImp dao = new CourseDaoImp();

			System.out.println("Enter  Cource Title:");
			String courseTital = sc.next();

			Course c = dao.displayCourseDetails(courseTital);
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}