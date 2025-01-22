package service;

import Entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    private Map<String, Employee> employees;

    public Employee createEmployee(String name, String surname, String email, String password, String role) {
        if (getAllEmployeMails().contains(email)) {
            Employee emp = new Employee(name,surname,email,password,role);
            employees.put(email,emp);
            return emp;
        }
        else {
            System.out.println("Email address already exist\n");
        }
        return null;
    }

    public List<String> getAllEmployeMails() {
        List<String> emails = new ArrayList<String>();
        for (Employee employee : employees.values())
        {
            emails.add(employee.getEmail());
        }
        return emails;
    }

    public Employee getEmployee(String email) {
        return employees.get(email);
    }

    public void SetEmployeeName(String name,String email) {
        employees.get(email).setName(name);
    }

    public void SetEmployeeSurName(String surName,String email) {
        employees.get(email).setName(surName);
    }

    public void SetEmployeePassword(String password,String email) {
        employees.get(email).setName(password);
    }
    public void SetEmployeeRole(String role,String email) {
        employees.get(email).setRole(role);
    }

    public List<Employee> filterEmployeesByMail(String email) {
        List<Employee> employeesByMail = new ArrayList<Employee>();
        for (Employee employee : employees.values())
        {
            if (employee.getEmail().contains(email)){
                employeesByMail.add(employee);
            }
        }
        return employeesByMail;
    }

    public List<Employee> filterEmployeesByRole(String role) {
        List<Employee> employeesByRole = new ArrayList<Employee>();
        for (Employee employee : employees.values())
        {
            if (employee.getRole().equals(role)){
                employeesByRole.add(employee);
            }
        }
        return employeesByRole;
    }

    public List<Employee> filterEmployeesByName(String name) {
        List<Employee> employeesByName = new ArrayList<Employee>();
        for (Employee employee : employees.values())
        {
            if (employee.getName().equals(name)){
                employeesByName.add(employee);
            }
        }
        return employeesByName;
    }


    public void deleteEmployee(String email) {
        employees.remove(employees.get(email));
    }
}
