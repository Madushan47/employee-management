/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madushan.controller;

import com.madushan.dao.LoginDAO;
import com.madushan.dao.LoginDAOImpl;
import com.madushan.model.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Madushan
 */
public class LoginController extends HttpServlet {
    
    LoginDAO loginDAO = null;
    
    public LoginController(){
        loginDAO = new LoginDAOImpl();
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        String status = loginDAO.authenticate(login);
        
        if(status.equals("true")) {
            session.setAttribute("email", login.getEmail());
            response.sendRedirect("EmployeeController");
        }
        if(status.equals("false")) {
            response.sendRedirect("index.jsp?status=false");
        }
        if(status.equals("error")) {
            response.sendRedirect("index.jsp?status=error");
        }
    }



}
