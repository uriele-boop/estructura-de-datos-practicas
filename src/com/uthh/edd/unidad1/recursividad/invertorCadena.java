/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad1.recursividad;

/**
 *
 * Autor: Angel Uriel Espinoza Alvarado 4C
 */
public class invertorCadena {

    // Método principal (Patrón Wrapper)
    public String Invertir(String texto) {
        // Validaciones iniciales (casos extremos) aqui definimos que si es una palabra null va a retornsr un espacio vacio
        if (texto == null) { 
            return ""; 
        }
        //Si el indice de la palabra esta en la posicion 0, quiere decir que solo es un caracter y va a retornar ese caracter
        if (texto.length() <= 1) { 
            return texto; 
        }
        
        // Llamada inicial al método recursivo empezando en la posición 0
        return invertirAuxiliar(texto, 0);
    }

    // Método recursivo privado
    //definimos los parametros que vamos a usar sera s, indice que enviaremos al metodo wrapper
    private String invertirAuxiliar(String s, int indice) {
        // Caso base: llegamos a la última letra de la palabra, y se pone -1 para definir hasta que posicion termina la palabra y se concatena ese caracter al principio para que asi se vayan concatenando
        if (indice == s.length() - 1) {
            return "" + s.charAt(indice);
        }
        
        // Paso recursivo: cuando el caracter llega a la posicion x,llamada a la siguiente letra + el carácter actual para que se vayan concatenando
        return invertirAuxiliar(s, indice + 1) + s.charAt(indice);
    }
}
    

