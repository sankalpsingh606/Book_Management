package com.sankalpsingh.otp.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/clientVerify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp = request.getParameter("otp");
		HttpSession session = request.getSession();
		String op = (String) session.getAttribute("otp");
		if (otp.equals(op)) {
			response.sendRedirect("client?opt=2");
		}
		else {
			response.getWriter().println("Not Verified");
		}
	}

}
