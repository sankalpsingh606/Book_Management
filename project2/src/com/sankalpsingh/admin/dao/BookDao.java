package com.sankalpsingh.admin.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import model.Book;
import com.sankalpsingh.hibernate.MyConnection;

public class BookDao {
	private static BookDao sd = new BookDao();

	private BookDao() {
	}

	public static BookDao getPersonDao() {
		return sd;
	}

	public int insert(Book b) {
		int i = 0;
		Session session = MyConnection.getSessionFactory().openSession();
		session.persist(b);
		session.beginTransaction().commit();
		session.close();
		i = 1;
		return i;
	}

	public int remove(int id) {
		int i = 0;
		Session session = MyConnection.getSessionFactory().openSession();
		session.beginTransaction();
		Book b = BookDao.getPersonDao().getRecordById(id);
		session.delete(b);
		session.getTransaction().commit();
		session.close();
		i = 1;
		return i;
	}
	public int update(Book book) {
		System.out.println("Book "+ book);
		int i = 0;
		Session session = MyConnection.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
		session.close();
		i = 1;
		return i;
	}
	
	
	public Book getRecordById(int id) {

		Book b = null;
		Session session = MyConnection.getSessionFactory().openSession();
		session.beginTransaction().commit();
		b = session.get(model.Book.class, id);
		System.out.println(b);
		session.close();	
		return b;
			}

	


	@SuppressWarnings("deprecation")
	public List<Book> Book() {
		List<Book> book = new ArrayList<>();
		Session session = MyConnection.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(model.Book.class);
		session.beginTransaction().commit();
		book = cr.list();
		
		session.close();
		return book;
}
	/* using HQL
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public List<Book> allBook(){
		Session session =MyConnection.getSessionFactory().openSession();
		org.hibernate.Query q=session.createQuery(" from com.sankalp.model.Book");
		return q.list();
		
	}*/

}