package pages;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloworldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doGet : invoked by" + Thread.currentThread());

		// set response content type

		resp.setContentType("test/html"); // resp packet header

		// to send resp from server --> clny
	}

	@Override
	public void destroy() {
		System.out.println("in destroy : invoked by" + Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init : invoked by" + Thread.currentThread());
	}

}
