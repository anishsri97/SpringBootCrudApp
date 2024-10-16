package com.myApp.myApplication.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApplication.Service.employeeService;
import com.myApp.myApplication.employeeDAO.employeeDAO;
import com.myApp.myApplication.entity.employee;

@RestController
@RequestMapping("/api")
public class restController 
{


   private employeeService empService;
   
  
   // injection of constructor
   @Autowired
   restController(employeeService emp)
   {
	   this.empService=emp;
   }
   //List<employee> em =null;
   // get result
   @GetMapping("/hello")
   public String  getList()
   {
	  return "hello";   
   }
   
   @GetMapping("/employees")
   public List<employee> getdata()
   {
	   return empService.employeeList();
   }
   
   
   @GetMapping("/employee/{id}")
   public employee getByid(@PathVariable int id)
   {
	   employee e =  empService.getById(id);
	   if(e==null) throw new RuntimeException("not found"+id);
	   return e;
   }
   
   @PostMapping("/employeeAdd")
   public employee add(@RequestBody employee emp)
   {
	   emp.setId(0);
	   empService.add(emp);
	   return emp;
   }
   
   @PutMapping("/update")
   public employee update(@RequestBody employee emp)
   {
	    employee e=empService.add(emp);
	    return e;
   }
   
   @DeleteMapping("delete/{id}")
   public employee deleteEmp(@PathVariable int id)
   {
	   employee e = empService.getById(id);
	   if(e==null) throw new RuntimeException("id not found in database"+id);
	   empService.deleteByid(id);
	   return e;
   }
   
   
   
   
}
