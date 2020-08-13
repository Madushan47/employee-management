/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madushan.dao;

import com.madushan.model.Login;

/**
 *
 * @author Madushan
 */
public interface LoginDAO {
    
    String authenticate(Login login);
}
