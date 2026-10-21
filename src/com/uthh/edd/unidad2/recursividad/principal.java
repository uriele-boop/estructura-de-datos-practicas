/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad2.recursividad;
import java.util.Scanner;



/**
 *
 * Angel Uriel Espinoza Alvarado 4C
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        palindromo validador = new palindromo(); 
        
        System.out.println("reconocer: " + validador.esPalindromo("reconocer"));
        System.out.println("radar: " + validador.esPalindromo("radar"));
        System.out.println("hola: " + validador.esPalindromo("hola"));
        System.out.println("Cadena vacía: " + validador.esPalindromo(""));
        System.out.println("Solo 'a': " + validador.esPalindromo("a"));
        
        System.out.print("Ingresa tu propia palabra o frase para evaluar: ");
        String palabra = scanner.nextLine(); 
        
        boolean resultado = validador.esPalindromo(palabra);
        
        if (resultado) {
            System.out.println("La palabra " + palabra+ " SÍ es un palindromo");
        } else {
            System.out.println("La palabra " + palabra+ " NO es un palindromo.");
        }
    }
    
}
