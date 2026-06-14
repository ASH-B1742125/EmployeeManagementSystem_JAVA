package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewEmployees")

public class ViewEmployeeServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO dao =
                new EmployeeDAO();

        List<Employee> list =
                dao.getAllEmployees();

        request.setAttribute(
                "employees",
                list);

        request.getRequestDispatcher(
                "viewEmployees.jsp")
                .forward(
                        request,
                        response);
    }
}
