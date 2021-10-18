/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolenguaje;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class registro {

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _diseñador
     */
    public String getDiseñador() {
        return _diseñador;
    }

    /**
     * @param _diseñador the _diseñador to set
     */
    public void setDiseñador(String _diseñador) {
        this._diseñador = _diseñador;
    }

    /**
     * @return the _TipoSistema
     */
    public String getTipoSistema() {
        return _TipoSistema;
    }

    /**
     * @param _TipoSistema the _TipoSistema to set
     */
    public void setTipoSistema(String _TipoSistema) {
        this._TipoSistema = _TipoSistema;
    }

    /**
     * @return the _fechaversion
     */
    public Date getFechaversion() {
        return _fechaversion;
    }

    /**
     * @param _fechaversion the _fechaversion to set
     */
    public void setFechaversion(Date _fechaversion) {
        this._fechaversion = _fechaversion;
    }

    /**
     * @return the _Paradigma
     */
    public String getParadigma() {
        return _Paradigma;
    }

    /**
     * @param _Paradigma the _Paradigma to set
     */
    public void setParadigma(String _Paradigma) {
        this._Paradigma = _Paradigma;
    }
    //PRIMER CONSTRUCTOR CREADO
    private int _id;   
    private String _nombre;
    private String _diseñador;
    private String _TipoSistema;
    private Date  _fechaversion;
    private String _Paradigma;
    
    //SEGUNDO CONSTRUCTOR
    public registro(){
        this. _id = 0;
        this. _nombre = "";
        this. _diseñador = "";
        this. _TipoSistema = "";
        this. _fechaversion = new Date ();
        this. _Paradigma = "";
    }
   
   //CREAR OTRO CONSTRUCTOR PARA QUE TRAIGA Y JALE ESOS DATOS DEL CONSTRUCTOR QUE ESTA CREADO ARRIBA DE ESTE...
    public registro(int id, String nombre, String diseñador, String TipoSistema, Date fechaversion, String Paradigma){
        this. _id = id;
        this. _nombre = nombre;
        this. _diseñador = diseñador;
        this. _TipoSistema = TipoSistema;
        this. _fechaversion = fechaversion;
        this. _Paradigma = Paradigma;
    }
    
     public ArrayList<String> obtenerCampos(){
        ArrayList<String> campos = new ArrayList<String>();
        campos.add(String.valueOf(this.getId()));
        campos.add(this.getNombre());
        campos.add(this.getDiseñador());
        campos.add(this.getTipoSistema());
        campos.add(this.getParadigma());
        campos.add("____");
      
        return campos;
        
     }
}
