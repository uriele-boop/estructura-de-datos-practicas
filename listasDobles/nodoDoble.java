/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad3.listasDobles;

/**
 *
 * @author Angel
 */
public class nodoDoble {
    private int dato;
    private nodoDoble siguiente;
    private nodoDoble anterior; //nuevo
    
    public nodoDoble(int x){
        dato=x;
        siguiente=null;
        anterior=null;
    }


    public int getDato() {
        return dato;
    }

   
    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoDoble getSiguiente() {
        return siguiente;
    }

 
    public void setSiguiente(nodoDoble siguiente) {
        this.siguiente = siguiente;
    }


    public nodoDoble getAnterior() {
        return anterior;
    }


    public void setAnterior(nodoDoble anterior) {
        this.anterior = anterior;
    }
    
}
