/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad3.calificaciones;

/**
 *
 * Autor:Agel Uriel Espinoza
 */
public class nodo {
    private int dato;
    private nodo siguiente;

    public nodo(int x) {
        dato = x;
        siguiente = null;
    }

    public nodo(int x, nodo sig) {
        dato = x;
        siguiente = sig;
    }

    public void setDato(int x) {
        dato = x;
    }

    public int getDato() {
        return dato;
    }

    public void setSiguiente(nodo sig) {
        siguiente = sig;
    }

    public nodo getSiguiente() {
        return siguiente;
    }
}