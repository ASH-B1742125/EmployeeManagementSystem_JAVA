package com.example.dao;

import com.example.model.Employee;

public class TestEmployeeDAO {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Ashutosh");
        emp.setDepartment("IT");
        emp.setSalary(50000);
        emp.setEmail("ashutosh@gmail.com");

        EmployeeDAO dao = new EmployeeDAO();

        boolean result =
                dao.addEmployee(emp);

        if(result) {

            System.out.println(
                    "Employee Added Successfully");

        } else {

            System.out.println(
                    "Failed To Add Employee");
        }
    }
}
