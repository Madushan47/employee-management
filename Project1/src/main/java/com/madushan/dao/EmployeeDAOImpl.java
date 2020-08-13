/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madushan.dao;

import com.madushan.db.dbconnection;
import com.madushan.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Madushan
 */
public abstract class EmployeeDAOImpl implements EmployeeDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    PreparedStatement preparedStatement = null;
    
    @Override
    public List<Employee> get() {

        //create reference variable
        List<Employee> list = null;
        Employee employee = null;

        try {
            list = new ArrayList<>();

            //create a sql query
            String sql = "SELECT * FROM employee_tbl";

            //get database connection
            connection = dbconnection.openconnection();

            //create a statement
            statement = connection.createStatement();
            

            //Excecute sql query
            resultset = statement.executeQuery(sql);

            //Process the resultset
            while (resultset.next()) {

                employee = new Employee();
                employee.setId(resultset.getInt("id"));
                employee.setName(resultset.getString("name"));
                employee.setDepartment(resultset.getString("department"));
                employee.setDob(resultset.getString("dob"));

                //Add employee to list
                list.add(employee);

            }

        } catch (SQLException e) {
        }
        //return the list
        return list;
    }
    @Override
    public boolean save(Employee e){
      boolean flag = false;
      
      String sql = "INSERT INTO employee_tbl(name,dob,department)VALUES('"+e.getName()+"', '"+e.getDob()+"', '"+e.getDepartment()+"')";
      connection = dbconnection.openconnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
      
      
    }
    @Override
        public Employee get(int id){
            Employee employee = null;
            
            employee = new Employee();
            String sql = "SELECT * FROM employee_tbl WHERE id="+id;
            connection = dbconnection.openconnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            resultset = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(resultset.next()){
                employee.setId(resultset.getInt("id"));
                employee.setName(resultset.getString("name"));
                employee.setDepartment(resultset.getString("department"));
                employee.setDob(resultset.getString("dob"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return employee;
        }
        @Override
        public boolean update(Employee e){
            boolean flag = false;
            
            String sql = "UPDATE employee_tbl SET name='"+e.getName()+"', dob='"+e.getDob()+"', department='"+e.getDepartment()+"' WHERE id="+e.getId();
            connection = dbconnection.openconnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return flag;
        }
        
    @Override
        public boolean delete(int id){
        boolean flag = false;
        String sql = "DELETE FROM employee_tbl WHERE id="+id;
        connection = dbconnection.openconnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
        
        }     
}
