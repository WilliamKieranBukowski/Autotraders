package Servlets;/*
@Author: William Bukowski

    Servlets class for UserLogin: provides responses to requests for userValidation
 */


import Util.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


@WebServlet("/Login")
public class LoginServ extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(Validate.checkUser(username, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome to Autotraders");
            rs.forward(request, response);
        }
        else
        {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("home.html");
            rs.include(request, response);
        }
    }

}
