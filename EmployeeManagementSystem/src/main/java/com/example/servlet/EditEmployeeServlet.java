package com.example.servlet;

import java.io.IOException;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editEmployee")

public class EditEmployeeServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

        EmployeeDAO dao =
                new EmployeeDAO();

        Employee emp =
                dao.getEmployeeById(id);

        request.setAttribute(
                "employee",
                emp);

        request.getRequestDispatcher(
                "editEmployee.jsp")
                .forward(
                        request,
                        response);
    }
}