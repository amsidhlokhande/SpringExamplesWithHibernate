/**
 * 
 */
package com.amsidh.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.dto.Employee;

/**
 * @author VIRU
 * 
 */
@Service
public class EmployeeDaoImpl implements EmployeeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.service.EmployeeDao#addEmployee(com.amsidh.dto.Employee)
	 */
	@Autowired
	SessionFactory sessionFatory;

	/**
	 * @return the sessionFatory
	 */
	public SessionFactory getSessionFatory() {
		return sessionFatory;
	}

	/**
	 * @param sessionFatory
	 *            the sessionFatory to set
	 */
	public void setSessionFatory(SessionFactory sessionFatory) {
		this.sessionFatory = sessionFatory;
	}

	@Override
	public void addEmployee(Employee employee) {
		sessionFatory.getCurrentSession().beginTransaction();
		sessionFatory.openSession().saveOrUpdate(employee);
		sessionFatory.getCurrentSession().flush();
		sessionFatory.getCurrentSession().close();

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.service.EmployeeDao#getEmployee(java.lang.Integer)
	 */
	@Override
	public Employee getEmployee(Integer employeeId) {
		sessionFatory.getCurrentSession().beginTransaction();
		Employee emp = (Employee) sessionFatory.openSession().get(
				Employee.class, employeeId);
		sessionFatory.getCurrentSession().flush();
		sessionFatory.getCurrentSession().close();

		return emp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.service.EmployeeDao#getAllEmployee()
	 */
	@Override
	public List<Employee> getAllEmployee() {
		sessionFatory.getCurrentSession().beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) sessionFatory.openSession()
				.createQuery("from Employee").list();
		sessionFatory.getCurrentSession().flush();
		sessionFatory.getCurrentSession().close();
		return empList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.service.EmployeeDao#deleteEmployee(java.lang.Integer)
	 */
	@Override
	public void deleteEmployee(Integer employeeId) {
		sessionFatory.getCurrentSession().beginTransaction();
		sessionFatory.openSession().delete(
				(Employee) sessionFatory.openSession().get(Employee.class,
						employeeId));
		sessionFatory.getCurrentSession().flush();
		sessionFatory.getCurrentSession().close();

	}

	@Override
	public void updateEmployee(Employee employee) {
		sessionFatory.getCurrentSession().beginTransaction();
		Employee emp = (Employee) sessionFatory.openSession().get(
				Employee.class, employee.getEmployeeId());
		emp.setAddress(employee.getAddress());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setSalary(employee.getSalary());
		sessionFatory.openSession().saveOrUpdate(emp);
		sessionFatory.getCurrentSession().flush();
		sessionFatory.getCurrentSession().close();
		
	}

}
