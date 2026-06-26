package dao;

import static util.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImp implements ICourseDao {

	@Override
	public String lauchNewCourse(Course transientCourse) {

		// get Session from SF : getCurrentSession
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			session.persist(transientCourse); // transientCourse : persistent
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}

		return "Launched new Course with ID: " + transientCourse.getId();
	}

	@Override
	public String cancelCourse(int courseId) {
		// get Session from SF : getCurrentSession
		Session session = getFactory().getCurrentSession();
		String mesg = "Cancelling course failed....... ";
		Transaction tx = session.beginTransaction();

		try {
			Course c = session.get(Course.class, courseId);
			if (c != null) {
				session.delete(c); // c:Removed it is only marked for removal
				mesg = "Course cancelled......";
			}
			tx.commit(); // associated child recs (student) and then parent rec will be deleted due to
							// cascading.

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}
		return mesg;
	}

	@Override
	public Course displayCourseDetails(String courseTitle) {
		// TODO Auto-generated method stub
		Course c = null;
		Session session = getFactory().getCurrentSession();
		String jpql = "Select c from Course c where c.title = :title";
		Transaction tx = session.beginTransaction();

		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", courseTitle).getSingleResult();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}
		return c;
	}

}
