package com.api.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.api.entity.Employee;

import jakarta.inject.Inject;

public class EmployeeDAO implements Dao{
	
	
private SessionFactory factory = SessionUtil.getFactory();
	
	@SuppressWarnings("deprecation")
	@Override
	public void saveEmployee(Employee Employee) {
		Transaction transaction = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(Employee);
//			session.
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
	}
	
	
	@Override
	public Employee getEmployeeById(long id) {
		Transaction transaction = null;
		Employee Employee = null;
		try(Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			Employee = session.get(Employee.class, id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
		}
		return Employee;
	}
	
	
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> Employees = null;
//		try(Session session = factory.openSession()) {
	     Session session = factory.openSession();
	     transaction = session.beginTransaction();
			Employees = session.createNativeQuery("Select * from Employee",Employee.class).list();
			transaction.commit();
////		} catch (Exception e) {
//			if(transaction != null)
//				transaction.rollback();
//		}
		return Employees;
	}
	

	
	public int updateEmployee(int id, Employee emp){
	     if(id <=0)  
	         return 0;  
	     Session session = factory.openSession();
	      Transaction tx = session.beginTransaction();
	      String hql = "update Employee set name = :name, age=:age, email=:email, phone=:phone where id = :id";
	      Query query = session.createQuery(hql);
	      query.setParameter("id",id);
	      query.setParameter("name",emp.getName());
	      query.setParameter("age",emp.getAge());
	      query.setParameter("email",emp.getEmail());
	      query.setParameter("phone",emp.getPhone());


	      int rowCount = query.executeUpdate();
	      System.out.println("Rows affected: " + rowCount);
	      tx.commit();
	      session.close();
	      return rowCount;
	  }
	


	@Override
	  public int deleteEmployeeById(int id) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from Employee where id = :id";
	    Query query = session.createQuery(hql);
	    query.setParameter("id",id);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	  }



}
