package com.sankalpsingh.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Book;
import model.Cart;
import model.Client;

import com.sankalpsingh.admin.dao.AdminDao;
import com.sankalpsingh.admin.dao.BookDao;
import com.sankalpsingh.client.dao.ClientDao;

import model.Admin;

@WebServlet("/client")
public class ClientController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if (opt != null) {
			int choice = Integer.parseInt(opt);

			switch (choice) {
			case 1:
				ClientLogin(request, response);
				break;
			case 2:
				ClientRegister(request, response);
				break;
			case 3:
			BookRecode(request, response);
				break;
			case 4:
				CartRecode(request, response);
				break;
			case 5:
				AddtoCart(request, response);
				break;
			case 6:
				DeleteToCart(request, response);
				break;
		
			}
		}
	}

	private void BookRecode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Book> book = BookDao.getPersonDao().Book();
		request.setAttribute("list", book);
		request.getRequestDispatcher("clienthome.jsp").forward(request,response);
	}

	private void DeleteToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int i = ClientDao.getClientDao().cartRemove(id);
		if (i > 0) {
			request.getRequestDispatcher("client?opt=4").forward(request,response);
			
			System.out.println("remove");
		} else {
			out.print(" Upload Failed");
		}


		
	}

	private void AddtoCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String itemId=(request.getParameter("id"));
		System.out.println(itemId);
		Book b=BookDao.getPersonDao().getRecordById(Integer.parseInt(itemId));
		System.out.println(b.toString());

		Cart c =new Cart();
		c.setItemId(b.getId());
		c.setItemName(b.getBookname());
		c.setItemPrice(b.getBookprice());
		c.setItemDescription(b.getBookdescription());
		c.setItemFilename(b.getFilename());
		System.out.println(c.toString());
		int i =ClientDao.getClientDao().addToCart(c);
		if (i > 0) {
			System.out.print("Succesfully Book Upload");
			request.getRequestDispatcher("client?opt=4").forward(request,response);
			
		} else {
			response.getWriter().print(" Upload Failed");
		}		
	}

	private void CartRecode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Cart> c = ClientDao.getClientDao().cartRecode();
		request.setAttribute("list", c);
		request.getRequestDispatcher("cart.jsp").forward(request,response);
	}


	private void ClientRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String mobile = (String) session.getAttribute("mobile");
		String password = (String) session.getAttribute("password");

		Client c = new Client();
		c.setName(name);
		c.setMobile(mobile);
		c.setEmail(email);
		c.setPassword(password);

		int i = ClientDao.getClientDao().insert(c);
		if (i > 0) {
			out.print("Successfully Register");
		} else {
			out.print(" Register Failed");
		}
	}

	private void ClientLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Client a = new Client();
		a.setEmail(email);
		a.setPassword(password);

		Client i = ClientDao.getClientDao().log(a);
		if (i != null) {
			request.getSession().setAttribute("LogedIn", i);
			System.out.println(i);
			// response.sendRedirect("adminHome.jsp");
			response.sendRedirect("client?opt=3");
		} else {
			out.print("failed login");
			System.out.println("bye");
		}
	}
	
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}
}
