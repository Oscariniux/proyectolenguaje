/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uttilities;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Oscar
 */
public class layout { 
        public static void printSeperator () {
    System.out.println("=====================================================");   
    }
    
    public static void printHeader (String header) {
    int headerLength = header.length();  
    int startpoint = (int) Math.floor((80 - headerLength)/2);
    String headerBuffer = "";
    for(int i = 0; i<startpoint; i++){
    headerBuffer += " ";
    }
    headerBuffer += header;
    startpoint = headerBuffer.length();
    for(int i = startpoint; i<80; i++){
    headerBuffer += " ";
    }
    printSeperator();
    System.out.println(headerBuffer);
    printSeperator();
    }
    
        public static void printMenu(){
         printHeader("Menu");
        
        System.out.println("\nM - Mostrar\n I - Ingresar\n A - Actualizar\n E - Eliminar\n\n S - Salir\n");
        printSeperator();
        System.out.println("Seleccione una opción : ");
            
        }
     
        
     public static String obtenerValorparaCampo(String Etiqueta, String ValorPredeterminado, Scanner entradaTeclado){
        System.out.println(Etiqueta + " (" + ValorPredeterminado + ") : ");
        String valor = entradaTeclado.nextLine(); 
        if (valor.isEmpty()){
            return ValorPredeterminado;  
        }
        return valor;
    } 
     
     public static void imprimirEnColumna(ArrayList<String> columnas, ArrayList<Integer> anchos, String separator) throws Exception{
        if ( columnas.size() != anchos.size()) {
            throw new Exception("Las columnas no coinciden con los anchos");
        }
        System.out.print(separator);
        for (int i = 0; i < columnas.size(); i++){
            // Columna1    10      "1%S-10s"    "Columna1  "
            String columna = String.format("%1$-" + String.valueOf(anchos.get(i)) +"s", columnas.get(i));
            columna = columna.substring(0, anchos.get(i));
            
            System.out.print(columna);
            System.out.print(separator);
        
        }
        System.out.println();
    }
}
