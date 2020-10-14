package com.sankalpsingh.otp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;

@WebServlet("/adminRegister")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobile =request.getParameter("mobile");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin a = new Admin();
		a.setName(name);
		a.setMobile (mobile);
		a.setEmail(email);
		a.setPassword(password);

		HttpSession session = request.getSession();
		session.setAttribute("Admin", a);
		String otp = OTPGenerator.generateOTP();
		session.setAttribute("otp", otp);
		EmailClient c = new EmailClient();
		c.sendOTP(email, otp);
		response.sendRedirect("adminverify.jsp");

		session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("mobile", mobile);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
	}

}
