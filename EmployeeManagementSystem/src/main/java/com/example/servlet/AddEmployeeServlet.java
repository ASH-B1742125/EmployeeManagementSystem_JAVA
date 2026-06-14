package com.example.servlet;

import java.io.IOException;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.util.EmailUtil;

@WebServlet("/addEmployee")

public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String department =
                request.getParameter("department");

        double salary =
                Double.parseDouble(
                        request.getParameter("salary"));

        String email =
                request.getParameter("email");

        Employee emp = new Employee();

        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        emp.setEmail(email);

        EmployeeDAO dao =
                new EmployeeDAO();

        boolean result =
                dao.addEmployee(emp);

        if(result) {

            EmailUtil.sendEmail(
                    email,
                    "Employee Record Created",
                    "Dear " + name +
                    ", your employee record has been created successfully.");

            response.getWriter().println(
                    "<h2>Employee Added Successfully</h2>");

        } else {

            response.getWriter().println(
                    "<h2>Failed To Add Employee</h2>");
        }
    }
}
