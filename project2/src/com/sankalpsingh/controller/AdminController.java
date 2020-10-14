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
import com.sankalpsingh.admin.dao.AdminDao;
import com.sankalpsingh.admin.dao.BookDao;

import model.Admin;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if (opt != null) {
			int choice = Integer.parseInt(opt);

			switch (choice) {
			case 1:
				AdminLogin(request, response);
				break;
			case 2:
				AdminRegister(request, response);
				break;
			case 3:
				BookUpload(request, response);
				break;
			case 4:
				BookRemove(request, response);
				break;
			case 5:
				BookRecode(request, response);
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
		request.getRequestDispatcher("adminbookrecode.jsp").forward(request,response);
	}

	private void BookRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int i = BookDao.getPersonDao().remove(id);
		if (i > 0) {
			response.sendRedirect("admin?opt=5");
			out.print("remove");
			System.out.println("remove");
			// request.getRequestDispatcher("bookrecode");
		} else {
			out.print(" Upload Failed");
		}

	}

	protected void BookUpload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String path = request.getServletContext().getRealPath("/");
		File f = new File(path, "uploadfile");

		String filename = System.currentTimeMillis() + ".jpg";
		File ft = new File(f, filename);

		boolean status = ServletFileUpload.isMultipartContent(request);
		if (status) {
			DiskFileItemFactory fileFactory = new DiskFileItemFactory();
			fileFactory.setRepository(f);
			ServletFileUpload uploader = new ServletFileUpload(fileFactory);
			try {
				List<FileItem> fileItemsList = uploader.parseRequest(request);

				Iterator<FileItem> file = fileItemsList.iterator();
				Book b = new Book();
				while (file.hasNext()) {
					FileItem ff = file.next();
					if (ff.isFormField()) {
						if (ff.getFieldName().equalsIgnoreCase("bookname")) {
							b.setBookname(ff.getString());
						} else if (ff.getFieldName().equalsIgnoreCase("bookprice")) {
							b.setBookprice(ff.getString());
						} else if (ff.getFieldName().equalsIgnoreCase("bookdescription")) {
							b.setBookdescription(ff.getString());
						}
					} else {
						ff.write(ft);
						b.setFilename(filename);
					}

				}

				System.out.println(ft.getAbsolutePath());
				String msg="Book Upload Successfully";
				int i = BookDao.getPersonDao().insert(b);
				if (i > 0) {
					//request.setAttribute("message",msg);
					//request.getRequestDispatcher("adminbookupload.jsp").forward(request, response);
					//request.setAttribute("message",msg);
					out.print("Succesfully Book Upload");
				} else {
					out.print(" Upload Failed");
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/*
		  String bookname=request.getParameter("bookname"); String
		  bookprice=request.getParameter("bookprice"); String
		  bookdescription=request.getParameter("bookdescription"); String filenam=
		  request.getParameter("filename");
		  
		  Book b=new Book(); b.setBookname(bookname); b.setBookprice(bookprice);
		  b.setBookdescription(bookdescription); b.setFilename(filenam);
		  
		  boolean status = ServletFileUpload.isMultipartContent(request); if (status) {
		  DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		  fileFactory.setRepository(f); ServletFileUpload uploader=new
		  ServletFileUpload(fileFactory);
		  
		  System.out.println(ft.getAbsolutePath()); int
		  i=BookDao.getPersonDao().insert(b); if(i>0) {
		  out.print("Succesfully Book Upload"); }else { out.print(" Upload Failed"); }
		  
		  }
		 */
	}

	private void AdminRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String mobile = (String) session.getAttribute("mobile");
		String password = (String) session.getAttribute("password");

		Admin a = new Admin();
		a.setName(name);
		a.setMobile(mobile);
		a.setEmail(email);
		a.setPassword(password);

		int i = AdminDao.getAdminDao().insert(a);
		if (i > 0) {
			out.print("Successfully Register");
		} else {
			out.print(" Register Failed");
		}
	}

	private void AdminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin a = new Admin();
		a.setEmail(email);
		a.setPassword(password);

		Admin i = AdminDao.getAdminDao().log(a);
		if (i != null) {
			request.getSession().setAttribute("LogedIn", i);
			System.out.println(i);
			// response.sendRedirect("adminHome.jsp");
			response.sendRedirect("adminhome.jsp");
		} else {
			out.print("failed login");
			System.out.println("bye");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}
}
