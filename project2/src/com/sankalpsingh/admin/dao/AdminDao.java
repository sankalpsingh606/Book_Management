package com.sankalpsingh.admin.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sankalpsingh.hibernate.MyConnection;

import model.Admin;

public class AdminDao {
	private static AdminDao sd=new AdminDao();
	private AdminDao() {
	}
	public static AdminDao getAdminDao() {
		return sd;
	}
	
	
	public int insert(Admin a) {
		int i = 0;
		Transaction transaction = null;
		try (Session session = MyConnection.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(a);
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
	public Admin log( Admin a)
	{

		Session session= MyConnection.getSessionFactory().openSession();
		 try{
		      Criteria c=session.createCriteria(model.Admin.class);
		  c.add(Restrictions.eq("email",a.getEmail()));
		  c.add(Restrictions.eq("password",a.getPassword()));
		  Admin a1= (Admin) c.uniqueResult(); 
		  
		  return a1;
		    }
		  catch(Exception ex)
		  {
		      ex.printStackTrace();
		  }
		  return null;
		}
	
	
	
	
	}
