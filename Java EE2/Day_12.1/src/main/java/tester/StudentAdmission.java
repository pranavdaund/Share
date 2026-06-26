package tester;

import static util.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImp;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {
		StudentDaoImp dao = new StudentDaoImp();
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("hibernate up n running !" + sf);

			System.out.println("Enter course title");
			String title = sc.next();
			System.out.println("Enter student details: name email");
			Student s1 = new Student(sc.next(), sc.next());

			String updateinfo = dao.admitNewStudent(s1, title);
			System.out.println(updateinfo);
		} // sf.close() => close conn pool clean up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}