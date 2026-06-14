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

@WebServlet("/sortEmployees")

public class SortEmployeeServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String column =
                request.getParameter("column");

        EmployeeDAO dao =
                new EmployeeDAO();

        List<Employee> employees =
                dao.getEmployeesSorted(column);

        request.setAttribute(
                "employees",
                employees);

        request.getRequestDispatcher(
                "sortEmployees.jsp")
                .forward(request, response);
    }
}
