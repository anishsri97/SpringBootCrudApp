package com.myApp.myApplication.employeeDAO;

import java.util.List;

import com.myApp.myApplication.entity.employee;

public interface employeeDAO 
{
   public List<employee> employeeList();
   
   public employee getById(int id);
   
   public employee add(employee emp);
   
   public void deleteByid(int id);
}
