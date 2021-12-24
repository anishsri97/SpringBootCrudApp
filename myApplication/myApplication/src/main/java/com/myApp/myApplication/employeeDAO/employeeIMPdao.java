package com.myApp.myApplication.employeeDAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myApp.myApplication.entity.employee;


@Repository
public class employeeIMPdao implements employeeDAO {

	
	public EntityManager em;
	
	// constructor injection
	@Autowired
	public employeeIMPdao(EntityManager em)
	{
		this.em=em;
	}
	
	@Override
	@Transactional
	public List<employee> employeeList() 
	{
		// get the session
		
		Session currentSession =em.unwrap(Session.class);
		// create the query
		
		//String str = "insert "
		Query<employee> query = currentSession.createQuery("from employee",employee.class);
		//execute and get result
		
		//Employee e = query.getFirstResult();
		List<employee> result = query.getResultList();
		//System.out.println(result); 
		return result;
		
	}
	
	
	@Override
	@Transactional
	public employee getById(int id)
	{
		Session csession = em.unwrap(Session.class);
		
		employee emp = csession.get(employee.class, id);
		
		
		return emp;
	}
	
	@Override
	@Transactional
	public employee add(employee emp)
	{
		Session csession = em.unwrap(Session.class);
		
	     csession.saveOrUpdate(emp);
	     return emp;
	}
	
	
	@Override
	@Transactional
	public void deleteByid(int id)
	{
		Session csession = em.unwrap(Session.class);
		
		Query qury = csession.createQuery("delete from employee where id=:ID");
	  
		qury.setParameter("ID",id);
		
		qury.executeUpdate();
	}
	
	

}
