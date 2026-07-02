package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImp;

public class CancelledStdentAdmission {

	public static void main(String[] args) {
		StudentDaoImp dao = new StudentDaoImp();
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter course title");
			String title = sc.next();
			System.out.println("Enter student Id:");
			int studentid = sc.nextInt();

			String updateinfo = dao.cancelAdmission(title, studentid);
			System.out.println(updateinfo);
		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}