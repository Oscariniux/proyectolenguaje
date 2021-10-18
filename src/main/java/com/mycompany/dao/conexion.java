/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Oscar
 */
public class conexion {
    public static Connection _conexion = null;
    private conexion(){   
    }
    
     public static Connection getconexion(){
        try {
            if(_conexion == null){
                Class.forName("org.sqlite.JDBC");
                _conexion = DriverManager.getConnection("jdbc:sqlite:proyectolenguajedb.db");
                return _conexion;
            } else {
                return _conexion;
            }
        
        } catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }
}

