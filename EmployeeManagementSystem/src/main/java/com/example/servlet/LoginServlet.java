package com.example.servlet;

import java.io.IOException;

import com.example.dao.UserDAO;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        UserDAO dao =
                new UserDAO();

        User user =
                dao.login(username, password);

        if(user != null) {
        	
        	HttpSession session =
        	        request.getSession();

        	session.setAttribute(
        	        "user",
        	        user);

        	if(user.getRole().equalsIgnoreCase("ADMIN")) {

                response.sendRedirect(
                        "adminDashboard.jsp");

            } else {

                response.sendRedirect(
                        "employeeDashboard.jsp");
            }

        } else {

            response.getWriter().println(
                    "<h2>Invalid Username or Password</h2>");
        }
    }
}