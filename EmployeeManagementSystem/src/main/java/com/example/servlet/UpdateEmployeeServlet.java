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

@WebServlet("/updateEmployee")

public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

        String name =
                request.getParameter("name");

        String department =
                request.getParameter("department");

        double salary =
                Double.parseDouble(
                        request.getParameter("salary"));

        String email =
                request.getParameter("email");

        Employee emp =
                new Employee();

        emp.setId(id);
        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        emp.setEmail(email);

        EmployeeDAO dao =
                new EmployeeDAO();

        boolean result =
                dao.updateEmployee(emp);

        if(result) {

            response.sendRedirect(
                    "viewEmployees");
            EmailUtil.sendEmail(
                    email,
                    "Employee Record Updated",
                    "Dear " + name +
                    ", your employee record has been updated successfully.");

        } else {

            response.getWriter().println(
                    "Update Failed");
        }
    }
}