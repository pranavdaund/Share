package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImp;

public class CancelCourse {

	public static void main(String[] args) {
		CourseDaoImp dao = new CourseDaoImp();
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter the Course Id");
			int courseId = sc.nextInt();

			String updateinfo = dao.cancelCourse(courseId);
			System.out.println(updateinfo);
		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}