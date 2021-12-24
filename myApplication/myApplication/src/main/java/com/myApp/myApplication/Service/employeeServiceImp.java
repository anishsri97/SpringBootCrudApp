package com.myApp.myApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myApp.myApplication.employeeDAO.employeeDAO;
import com.myApp.myApplication.entity.employee;


@Repository
public class employeeServiceImp implements employeeService {

	
	private employeeDAO empDao;
	
	@Autowired
	employeeServiceImp(employeeDAO empDao)
	{
		this.empDao=empDao;
	}
	
	@Override
	public List<employee> employeeList() {
		// TODO Auto-generated method stub
		return empDao.employeeList();
	}

	@Override
	public employee getById(int id) {
		// TODO Auto-generated method stub
		return empDao.getById(id);
	}

	@Override
	public employee add(employee emp) {
		// TODO Auto-generated method stub
		empDao.add(emp);
		return emp;

	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
           empDao.deleteByid(id);
	}

}
