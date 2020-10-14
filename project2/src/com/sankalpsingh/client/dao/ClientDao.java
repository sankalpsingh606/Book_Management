package com.sankalpsingh.client.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sankalpsingh.admin.dao.BookDao;
import com.sankalpsingh.hibernate.MyConnection;

import model.Admin;
import model.Book;
import model.Cart;
import model.Client;

public class ClientDao {
	private static ClientDao sd=new ClientDao();
	private ClientDao() {
	}
	public static ClientDao getClientDao() {
		return sd;
	}
	
	
	public int insert(Client c) {
		int i = 0;
		Transaction transaction = null;
		try (Session session = MyConnection.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(c);
			// commit transaction
			transaction.commit();
			i = 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return i;
	}

	public Client log( Client a)
	{

		Session session= MyConnection.getSessionFactory().openSession();
		 try{
		      Criteria c=session.createCriteria(model.Client.class);
		  c.add(Restrictions.eq("email",a.getEmail()));
		  c.add(Restrictions.eq("password",a.getPassword()));
		  Client a1= (Client) c.uniqueResult(); 
		  
		  return a1;
		    }
		  catch(Exception ex)
		  {
		      ex.printStackTrace();
		  }
		  return null;
		}
	
	public int addToCart(Cart c) {
		int i = 0;
		Transaction transaction = null;
		try (Session session = MyConnection.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(c);
			// commit transaction
			transaction.commit();
			i = 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return i;
	}

	@SuppressWarnings("deprecation")
	public List<Cart> cartRecode() {
		List<Cart> c = new ArrayList<>();
		Session session = MyConnection.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(model.Cart.class);
		session.beginTransaction().commit();
		c= cr.list();
		
		session.close();
		return c;
}
	public int cartRemove(int id) {
		int i = 0;
		Session session = MyConnection.getSessionFactory().openSession();
		session.beginTransaction();
		Cart c = ClientDao.getClientDao().getRecordById(id);
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		i = 1;
		return i;
	
	}
	
	public Cart getRecordById(int id) {

		Cart c = null;
		Session session = MyConnection.getSessionFactory().openSession();
		session.beginTransaction().commit();
		c = session.get(model.Cart.class, id);
		System.out.println(c);
		session.close();	
		return c;
			}


	}
