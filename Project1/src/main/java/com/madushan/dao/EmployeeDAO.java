/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madushan.dao;

import com.madushan.model.Employee;
import java.util.List;

/**
 *
 * @author Madushan
 */
public interface EmployeeDAO {
    
    List<Employee> get();
    
    boolean save(Employee e);
    
    Employee get(int id);
    
    boolean update(Employee e);
    
    boolean delete(int id);
}
