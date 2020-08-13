/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madushan.dao;

import com.madushan.db.dbconnection;
import com.madushan.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Madushan
 */
public class LoginDAOImpl implements LoginDAO{

    @Override
    public String authenticate(Login login) {
       String sql = "SELECT * FROM login WHERE email=? and password=?";

        try {
          
          Connection connection = dbconnection.openconnection();
          PreparedStatement  ps = connection.prepareStatement(sql);
          ps.setString(1, login.getEmail());
          ps.setString(2, login.getPassword());
          ResultSet rs = ps.executeQuery();
       
       if(rs.next()) {
           return "true";
       }else{
           return "false";
       }
    }catch(SQLException e){
    } 
        return "error";
}
}
