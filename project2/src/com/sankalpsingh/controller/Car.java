package com.sankalpsingh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class Car extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		HttpSession session =  request.getSession();
		if (session != null) {
			System.out.println("Hello");
			List<Integer> buyitems = (List<Integer>) session.getAttribute("products");
			Integer s = Integer.parseInt(request.getParameter("id"));
			if (buyitems != null) {
				buyitems.add(s);
			}
			else {
				List<Integer> number = new ArrayList<>();
				number.add(s);
				session.setAttribute("products", number);
			}
		}
		response.sendRedirect("client?opt=4");
	}

}
