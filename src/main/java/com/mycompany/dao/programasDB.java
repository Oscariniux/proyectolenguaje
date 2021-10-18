/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.proyectolenguaje.registro;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Oscar
 */
public class programasDB {
    private ArrayList _registro;
    
    public programasDB(){
        this._registro= new ArrayList<registro>();
    }
    
    public ArrayList<registro> getregistro(){
        return this.getregistro();
    }
    
    public void tableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS PROGRAM LENGUAJE"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " NOMBRE TEXT NOT NULL,"
                        + " DISEÑADOR TEXT NOT NULL,"
                        + " TIPO SISTEMA TEXT NOT NULL"
                        + " PARADIGMA TEXT NOT NULL"
                        + ")";
       
        try {
            Statement comando = conexion.getconexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
        } catch( Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<registro> getregistro(boolean forceLoad){
        try {
           if (forceLoad) {
                Statement comando =  conexion.getconexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from PROGRAM LENGUAJE;");
                this._registro.clear();
                while (misRegistro.next()) {
                    registro registro = new registro();
                    registro.setId(misRegistro.getInt("ID"));
                    registro.setNombre(misRegistro.getString("NOMBRE"));
                    registro.setDiseñador(misRegistro.getString("DISEÑADOR"));
                    registro.setTipoSistema(misRegistro.getString("TIPO SISTEMA"));
                    registro.setParadigma(misRegistro.getString("PARADIGMA"));
                    this._registro.add(registro);
                    
                }
                comando.close();
           }
           return this._registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return this._registro;
        }   
    }
    
    public registro getregistro(int id){
        try {
            String SQLGetByID = "SELECT * FROM PROGRAM LENGUAJE WHERE ID = ?;";
            PreparedStatement comando =  conexion.getconexion().prepareStatement(SQLGetByID);
            comando.setInt(1, id);
            ResultSet misRegistro = comando.executeQuery();
            registro registro = new registro();
            while (misRegistro.next()) {
                registro.setId(misRegistro.getInt("ID"));
                registro.setNombre(misRegistro.getString("NOMBRE"));
                registro.setDiseñador(misRegistro.getString("DISEÑADOR"));
                registro.setTipoSistema(misRegistro.getString("TIPO SISTEMA"));
                registro.setParadigma(misRegistro.getString("PARADIGMA"));
                break;
            }
            comando.close();

            return registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    }
    
    public int updateregistro(registro ItemToUpdate) {
        try {
            String SQLUpdate = "UPDATE PROGRAM LENGUAJE set NOMBRE=?, DISEÑADOR=?, TIPO SISTEMA=?, PARADIGMA=? where ID=?;";
            PreparedStatement comando = conexion.getconexion().prepareStatement(SQLUpdate);
            
            comando.setString(1, ItemToUpdate.getNombre());
            comando.setString(2, ItemToUpdate.getDiseñador());
            comando.setString(3, ItemToUpdate.getTipoSistema());
            comando.setString(4, ItemToUpdate.getParadigma());
            comando.setInt(5, ItemToUpdate.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     public int insertRegistroLenguaje(registro ItemToInsert) {
        try {
            String SQLInsert = "INSERT INTO PROGRAM LENGUAJE(NOMBRE, DISEÑADOR, TIPO SISTEMA, PARADIGMA) values (?, ?, ?, ?);";
            PreparedStatement comando = conexion.getconexion().prepareStatement(SQLInsert);
            
            comando.setString(1, ItemToInsert.getNombre());
            comando.setString(2, ItemToInsert.getDiseñador());
            comando.setString(3, ItemToInsert.getTipoSistema());
            comando.setString(4, ItemToInsert.getParadigma());
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     
    public int deleteregistro(registro ItemToDelete) {
        try {
            String SQLDelete = "DELETE FROM PROGRAM LENGUAJE WHERE ID = ?;";
            PreparedStatement comando = conexion.getconexion().prepareStatement(SQLDelete);
            
            comando.setInt(1, ItemToDelete.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
