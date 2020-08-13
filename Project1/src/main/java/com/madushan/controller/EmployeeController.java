/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madushan.controller;

import com.madushan.dao.EmployeeDAO;
import com.madushan.dao.EmployeeDAOImpl;
import com.madushan.model.Employee;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Madushan
 */
public class EmployeeController extends HttpServlet {
    
    //Create a ref variable for employee DAO
    EmployeeDAO employeeDAO = null;
    RequestDispatcher dispatcher = null;
    
    //Create consructor and initialize employee DAO
    public EmployeeController(){
        employeeDAO = new EmployeeDAOImpl() {};
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action == null){
            action = "LIST";
        }
        switch(action){
            case "LIST":
                listEmployees(request,response);
                break;
            case "EDIT":
                getSingleEmployee(request,response);
                break;
            case "DELETE":
                deleteEmployee(request,response);
                break;
            default:
                listEmployees(request,response);
                break;
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String bdate = request.getParameter("dob");
        String dpart = request.getParameter("department");
        
        Employee e = new Employee();
        e.setName(name);
        e.setDob(bdate);
        e.setDepartment(dpart);
        
        if(id.isEmpty() || id == null){
            
            if(employeeDAO.save(e)){
            request.setAttribute("msg", "Employee added Successfully !");
            }
        }else{
            e.setId(Integer.parseInt(id));
            if(employeeDAO.update(e)){
            request.setAttribute("msg", "Employee updated Successfully !");
        
            }
        }
 
       listEmployees(request,response);
    }
    
         public void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
              List<Employee> list = employeeDAO.get();
        
        //Add the employees to request object
        request.setAttribute("list", list);
        
        //Get the request dispatcher
        dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
        
        //Forward the req and res objects
        dispatcher.forward(request, response);
         }

         public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
             String id = request.getParameter("id");
             Employee employee = employeeDAO.get(Integer.parseInt(id));
             request.setAttribute("employee", employee);
              dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");
        
        //Forward the req and res objects
               dispatcher.forward(request, response);
             
         }
         public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
             String id = request.getParameter("id");
             if(employeeDAO.delete(Integer.parseInt(id))){
                request.setAttribute("msg", "Employee DELETED Successfully !");
             }
             listEmployees(request,response);
         }

}

