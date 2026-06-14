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

@WebServlet("/pagination")

public class PaginationServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int page = 1;
        int recordsPerPage = 3;

        if(request.getParameter("page") != null) {

            page = Integer.parseInt(
                    request.getParameter("page"));
        }

        EmployeeDAO dao =
                new EmployeeDAO();

        List<Employee> employees =
                dao.getEmployeesByPage(
                        (page - 1) * recordsPerPage,
                        recordsPerPage);

        request.setAttribute(
                "employees",
                employees);

        request.setAttribute(
                "currentPage",
                page);

        request.getRequestDispatcher(
                "pagination.jsp")
                .forward(request, response);
    }
}
