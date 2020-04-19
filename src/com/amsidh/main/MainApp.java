/**
 * 
 */
package com.amsidh.main;

import java.util.List;

import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.dto.Employee;
import com.amsidh.service.EmployeeDao;

/**
 * @author VIRU
 *
 */
public class MainApp {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AbstractApplicationContext context=new ClassPathXmlApplicationContext("resource/spring.xml");
        EmployeeDao employeedao=(EmployeeDao)context.getBean("employeeDao");
        Employee employee=new Employee(111,"Amsidh Lokhande",4546.45,"Kate Puram Chowk,Pune 411061");
        employeedao.addEmployee(employee);
        
        List<Employee> empList=employeedao.getAllEmployee();
        for(Employee emp:empList)
        {
        	System.out.println(emp.getEmployeeId()+"    "+emp.getEmployeeName()+"     "+emp.getSalary()+"        "+emp.getAddress());
        }
	}

}
