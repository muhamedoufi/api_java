package com.api.dao;

import java.util.Collection;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.api.entity.Etudiant;
import com.api.entity.Matiere;


public class EtudiantDao{
	
	
private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	public void save(Etudiant Etudiant) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(Etudiant);
//			session.
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
	}
	
	
	public Etudiant getById(long id) {
		Transaction transaction = null;
		Etudiant Etudiant = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Etudiant = session.get(Etudiant.class, id);
		    Hibernate.initialize(Etudiant.getMatieres());

			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Etudiant;
	}
	
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Etudiant> getAll() {
		Transaction transaction = null;
		List<Etudiant> Etudiants = null;
//		try(Session session = factory.openSession()) {
	     Session session = factory.openSession();
	     transaction = session.beginTransaction();
			Etudiants = session.createNativeQuery("Select * from Etudiant",Etudiant.class).list();
			transaction.commit();
////		} catch (Exception e) {
//			if(transaction != null)
//				transaction.rollback();
//		}
		return Etudiants;
	}
	

	
	public int update(int id, Etudiant etud){
	     if(id <=0)  
	         return 0;  
	     Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      String hql = "update Etudiant set nom = :nom, matricule=:matricule, filiere=:filiere,matieres=:matieres where id = :id";
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("nom",etud.getNom());
	      query.setParameter("matricule",etud.getMatricule());
	      query.setParameter("filiere",etud.getFiliere());
//	      Collection<Matiere> matieres = etud.getMatieres();
//	      if (matieres != null && !matieres.isEmpty()) {
//	          query.setParameter("matieres", matieres);
//	      }
//	      query.setParameter("matieres",etud.getMatieres());


	      int rowCount = query.executeUpdate();
	      System.out.println("Rows affected: " + rowCount);
	      tx.commit();
	      session.close();
	      return rowCount;
	  }
	


	  public int deleteById(int id) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from Etudiant where id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id",id);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	  }



}
