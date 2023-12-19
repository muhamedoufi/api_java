package com.api.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.api.entity.Matiere;


public class MatiereDao{
	
	
private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	public void save(Matiere Matiere) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(Matiere);
//			session.
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
	}
	
	
	public Matiere getById(long id) {
		Transaction transaction = null;
		Matiere Matiere = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Matiere = session.get(Matiere.class, id);
		    Hibernate.initialize(Matiere.getEtudiants());

			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Matiere;
	}
	
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Matiere> getAll() {
		Transaction transaction = null;
		List<Matiere> Matieres = null;
//		try(Session session = factory.openSession()) {
	     Session session = factory.openSession();
	     transaction = session.beginTransaction();
			Matieres = session.createNativeQuery("Select * from Matiere",Matiere.class).list();
			transaction.commit();
////		} catch (Exception e) {
//			if(transaction != null)
//				transaction.rollback();
//		}
		return Matieres;
	}
	

	
	public int update(int id, Matiere etud){
	     if(id <=0)  
	         return 0;  
	     Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      String hql = "update Matiere set nom = :nom, note=:note where id = :id";
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("nom",etud.getNom());
	      query.setParameter("note",etud.getNote());
	      query.setParameter("etudiants",etud.getEtudiants());
//	      query.setParameter("phone",etud.getPhone());


	      int rowCount = query.executeUpdate();
	      System.out.println("Rows affected: " + rowCount);
	      tx.commit();
	      session.close();
	      return rowCount;
	  }
	


	  public int deleteById(int id) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from Matiere where id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id",id);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	  }



}
