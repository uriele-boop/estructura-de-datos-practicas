/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.recursividad;

/**
 *
 * @author mi pc
 */
public class palindromo {
    public boolean esPalindromo(String texto) {
        //Valida que no este en mayusculas y minusculas juntas y espacios en blancos antes de retornarlo
        String textoLimpio = texto.toLowerCase().replace(" ", "");
        return esPalindromoAuxiliar(textoLimpio, 0, textoLimpio.length() - 1);
    }

    private boolean esPalindromoAuxiliar(String texto, int inicio, int fin) {
        //Returna cuando inicio y fin son iguales y que inicio sea mayor que fin
        if (inicio >= fin) {
            return true;
        }
        //Retorna si al momento de hacer el metodo recursivo los caracteres son diferentes
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }
        //Si se cumple el caso base el inicio se recorrera un caracter y fin recorrera hacia atras 
        return esPalindromoAuxiliar(texto, inicio + 1, fin - 1);
    }
}
