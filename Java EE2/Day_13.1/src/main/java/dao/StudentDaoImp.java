package dao;

import static util.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImp implements IStudentDao {

	@Override
	public String admitNewStudent(Student s, String courseName) {
		// get Session from SF : getCurrentSession
		String mesg = "Student admission failed";
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		String jpql = "Select c from Course c where c.title = :title";
		try {
			// get PERSISTENT Course Pojo From the Course name
			Course course = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();

			// => valid Course name (title) => course.exists!
			// c : Persistent

			if (course != null) {
//				s.setChosenCourse(course);
//				// Student ---> Course
//
//				course.getStudents().add(s);
//				// course ---> Student
				course.addStudent(s);
//				session.persist(s);// no longer required

				tx.commit();

				mesg = "Student admission successful ";
			} else {
				System.out.println("You enter in valid Course");

			}

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseTitle, int studentId) {
		// get Session from SF : getCurrentSession
		Session session = getFactory().getCurrentSession();
		String mesg = "Cancelling admission Failed";
		Transaction tx = session.beginTransaction();
		String jpql = "Select c from Course c where c.title = :title";
		try {
			// get PERSISTENT Course Pojo From the Course name
			Course course = session.createQuery(jpql, Course.class).setParameter("title", courseTitle)
					.getSingleResult();

			// => valid Course name (title) => course.exists!
			// c : Persistent

			// get student from it's id
			Student s = session.get(Student.class, studentId);

			if (s != null) {
				course.removeStudent(s);
				mesg = "Cancelled admission for Student " + s.getName();
			}
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}
		return mesg;
	}

}