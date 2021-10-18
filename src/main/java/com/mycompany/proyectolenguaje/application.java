/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolenguaje;
import com.mycompany.uttilities.layout;
import com.mycompany.dao.programasDB;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.ZonedDateTime;

/**
 *
 * @author Oscar
 */
public class application {
    private Scanner _entradatcl;    
 
 
private ArrayList _Lenguajes; 
private int _lenguajesIdCounter;

private programasDB _registroModel;
public application (Scanner entradaTeclado){
    this. _entradatcl = entradaTeclado;
    this. _Lenguajes = new ArrayList<registro>();
    this. _lenguajesIdCounter = 0;
    this. _registroModel = new programasDB();
    this. _registroModel.tableInitialize();
    this. _Lenguajes = this._registroModel.getregistro(true);
    
    
}
    
    public void activarEvento (String opcionMenu){
        
    switch(opcionMenu.toUpperCase()){   
            case "M":
                System.out.println("Mostrar Datos");  
                this.mostrarRegistros();
            break;
            
            case "I":
                    System.out.println("Ingresar Registro"); 
                    this.IngresarRegistro();
            break;
            
            case "A":
                    System.out.println("Actualizar Registro");  
                    this.actualizarRegistro();
            break;
            
            case "E":
                    System.out.println("Eliminar Registro");  
                    this.eliminarRegistro();
            break;
            
            case "S" :
                break;
              
        default: 
            System.out.println("Opcion no reconocida!!!");  
            break;
            
    }
    }
    
    private void IngresarRegistro(){
        layout.printHeader("Nuevo registro de Lenguaje de Programacion");
        registro nuevoRegistroLenguaje = new registro();
        nuevoRegistroLenguaje.setNombre(layout.obtenerValorparaCampo("Nombre del lenguaje programacion", "lenguaje programacion: ", this. _entradatcl ));
        nuevoRegistroLenguaje.setDiseñador(layout.obtenerValorparaCampo("Diseñador del lenguaje programacion", "Nombre del Diseñador: ", this. _entradatcl ));
        nuevoRegistroLenguaje.setTipoSistema(layout.obtenerValorparaCampo("Tipo de Sistema del lenguaje programacion", "Nombre del Diseñador: ", this. _entradatcl ));
        nuevoRegistroLenguaje.setParadigma(layout.obtenerValorparaCampo("paradigma del lenguaje", "Tipo paradigma:", this. _entradatcl ));
         int anio = Integer.parseInt(layout.obtenerValorparaCampo("Año de Lanzamirnto de la Version yyyy", "2016 ", this. _entradatcl ));
         int mes = Integer.parseInt(layout.obtenerValorparaCampo("Mes de Lanzamirnto de la Version 1-12", "6", this. _entradatcl ));
         int dia = Integer.parseInt(layout.obtenerValorparaCampo("Dia de Lanzamirnto de la Version 1-31", "3 ", this. _entradatcl ));
  
         this._Lenguajes.add(nuevoRegistroLenguaje);
         
         layout.printSeperator();
         
         System.out.println(this._Lenguajes.size());
            
    }
    
     private void mostrarRegistros(){
        layout.printSeperator();
        ArrayList<String> columnas = new ArrayList<String>();
        columnas.add("Codigo");
        columnas.add("Nombre Lenguaje");
        columnas.add("Diseñador del Lenguaje");
        columnas.add("Tipo de Sistema del Lenguaje");
        columnas.add("Tipo Paradigma del Lenguaje");
        columnas.add("Lanzamiento de la Version del Lenguaje");
        
        ArrayList<Integer> anchos = new ArrayList<Integer>();
        anchos.add(7);
        anchos.add(20);
        anchos.add(20);
        anchos.add(14);
        anchos.add(14);
        anchos.add(14);
        
        // |1234567890|123456789012345|
        try {
            //Imprimir encabezado
            layout.imprimirEnColumna(columnas, anchos, "|");
            layout.printSeperator();
            for(int i = 0; i< this._Lenguajes.size(); i++){
                columnas = ((registro) this._Lenguajes.get(i)).obtenerCampos();
                layout.imprimirEnColumna(columnas, anchos, "|");
            }
            
        } catch(Exception ex) {
            System.err.println("Error al imprimir " + ex.getMessage());
        }
    }
     
     
     
          private void actualizarRegistro(){
        layout.printHeader("Actualizar Registro");
        int selectedId = Integer.valueOf(layout.obtenerValorparaCampo("Ingrese Codigo Registro", "0", this._entradatcl));
        registro selectLenguaje = null;
        for( int i=0; i < this._Lenguajes.size(); i++){
            if( selectedId == ((registro)this._Lenguajes.get(i)).getId()) {
                selectLenguaje = (registro)this._Lenguajes.get(i);
                break;
            }
        }
        if (selectLenguaje == null ) {
            System.out.println("Registro solicitado no existe!!!");
        } else {
            selectLenguaje.setNombre(layout.obtenerValorparaCampo("Nombre del Lenguaje Programacion", selectLenguaje.getNombre(), this._entradatcl));
            selectLenguaje.setDiseñador(layout.obtenerValorparaCampo("Nombre del Diseñador", selectLenguaje.getDiseñador(), this._entradatcl));
            selectLenguaje.setTipoSistema(layout.obtenerValorparaCampo("Nombre Tipo Sistema", selectLenguaje.getTipoSistema(), this._entradatcl));
            selectLenguaje.setParadigma(layout.obtenerValorparaCampo("Tipo Paradigma Lenguaje", selectLenguaje.getParadigma(), this._entradatcl));
            int anio = Integer.parseInt(layout.obtenerValorparaCampo("Año de Lanzamiento Version  yyyy", " ", this._entradatcl));
            int mes = Integer.parseInt(layout.obtenerValorparaCampo("Mes de Lanzamiento 1-12", " ", this._entradatcl));
            int dia = Integer.parseInt(layout.obtenerValorparaCampo("Día de Lanzamiento 1-31", " ", this._entradatcl));
            layout.printSeperator();
            System.out.println("Registro Actualizado Satisfactoriamente!!!");
        }
        
    }
           private void eliminarRegistro(){
        layout.printHeader("Eliminar Registro");
        int selectedId = Integer.valueOf(layout.obtenerValorparaCampo("Ingrese Codigo Registro", "0", this._entradatcl));
        int encontradoEnIndice = -1;
        for( int i=0; i < this._Lenguajes.size(); i++){
            if( selectedId == ((registro)this._Lenguajes.get(i)).getId()) {
                encontradoEnIndice = i;
                break;
            }
        }
        if (encontradoEnIndice>=0){
            layout.printSeperator();
            String confirmado = layout.obtenerValorparaCampo("¿Desea Eliminar este Registro? S - N", "N", this._entradatcl);
            if (confirmado.toUpperCase().equals("S")){
                this._Lenguajes.remove(encontradoEnIndice);
                layout.printSeperator();
                System.out.println("Registro Eliminado Satisfactoriamente!!!");
            }
        } else {
            System.out.println("Registro solicitado no existe!!!");
        }
    
    }
}
