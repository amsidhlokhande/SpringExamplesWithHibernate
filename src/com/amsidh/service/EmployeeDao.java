package com.amsidh.service;

import java.util.List;

import com.amsidh.dto.Employee;

public interface EmployeeDao {
  public void addEmployee(Employee employee);
  public void updateEmployee(Employee employee);
  public Employee getEmployee(Integer employeeId);
  public List<Employee> getAllEmployee();
  public void deleteEmployee(Integer employeeId);
}
