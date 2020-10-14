package com.sankalpsingh.otp.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Client;

@WebServlet("/clientRegister")
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

		Client c = new Client();
		c.setName(name);
		c.setMobile(mobile);
		c.setEmail(email);
		c.setPassword(password);

		HttpSession session = request.getSession();
		session.setAttribute("Client", c);
		String otp = OTPGenerator.generateOTP();
		session.setAttribute("otp", otp);
		EmailClient c1 = new EmailClient();
		c1.sendOTP(email, otp);
		response.sendRedirect("clientverify.jsp");

		session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("mobile", mobile);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
	}

}
