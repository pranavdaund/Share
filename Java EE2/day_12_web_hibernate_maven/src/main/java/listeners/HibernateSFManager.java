package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import util.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class HibernateSFManager
 *
 */
@WebListener
public class HibernateSFManager implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public HibernateSFManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("in context destroyed....");
		HibernateUtils.getFactory().close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx inited");
		// create singleton instance of Sf
		HibernateUtils.getFactory();
	}

}
