package com.api.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.api.entity.Country;


public class CountryDao {
	
	
private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	public void save(Country Country) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(Country);
//			session.
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
	}
	
	
	
	public Country getById(long id) {
		Transaction transaction = null;
		Country Country = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Country = session.get(Country.class, id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Country;
	}
	
	
	public List<Country> getAll() {
		Transaction transaction = null;
		List<Country> Countrys = null;
//		try(Session session = factory.openSession()) {
	     Session session = factory.openSession();
	     transaction = session.beginTransaction();
			Countrys = session.createNativeQuery("Select * from Country",Country.class).list();
			transaction.commit();
////		} catch (Exception e) {
//			if(transaction != null)
//				transaction.rollback();
//		}
		return Countrys;
	}
	

	
	public int update(int id, Country emp){
	     if(id <=0)  
	         return 0;  
	     Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      String hql = "update Country set name = :name, emps=:emps where id = :id";
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("name",emp.getName());
	      query.setParameter("emps",emp.getEmps());
	      


	      int rowCount = query.executeUpdate();
	      System.out.println("Rows affected: " + rowCount);
	      tx.commit();
	      session.close();
	      return rowCount;
	  }
	


	  public int deleteById(int id) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from Country where id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id",id);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	  }



}
