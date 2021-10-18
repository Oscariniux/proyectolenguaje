/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolenguaje;
import com.mycompany.uttilities.layout;
import java.util.Scanner;
/**
 *
 * @author Oscar
 */
public class main {
   public static void main (String[] args) {
    layout.printSeperator();
    System.out.println("-------MENU-------");
    layout.printSeperator();
    layout.printHeader("MENU");

    String OpcionMenu = "";
    Scanner entradatcl = new Scanner (System.in);
    application lengProgra = new application(entradatcl);
    
    
    
    while (!(OpcionMenu.toUpperCase().equals("S"))){
        layout.printMenu();
        OpcionMenu = entradatcl.nextLine();
        System.out.println("El texto ingresado es igual a " + OpcionMenu);
        
        
        lengProgra.activarEvento(OpcionMenu);
        
        
        
        }
    } 
}
