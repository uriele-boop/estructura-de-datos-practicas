/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad3.calificaciones;

/**
 *
 * Autor: Angel Uriel Espinoza
 */
public class listaEnlazada {
    private nodo cabeza;
    private int tamanio;

    public listaEnlazada() {
        tamanio = 0;
        cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertarAlInicio(int dato) {
        nodo nuevo = new nodo(dato);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
        tamanio++;
    }

    public void insertarOrdenado(int dato) {
        if (estaVacia()) {
            cabeza = new nodo(dato);
            tamanio++;
        } else if (dato <= cabeza.getDato()) {
            insertarAlInicio(dato);
        } else {
            nodo aux = cabeza;
            while (aux.getSiguiente() != null && dato > aux.getSiguiente().getDato()) {
                aux = aux.getSiguiente();
            }
            nodo nuevo = new nodo(dato);
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            tamanio++;
        }
    }

    public boolean buscar(int dato) {
        nodo aux = cabeza;
        while (aux != null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String Tostring() {
        String res = "";
        nodo aux = cabeza;
        while (aux != null) {
            res = res + "[" + aux.getDato() + "]";
            aux = aux.getSiguiente();
        }
        res = res + "NULL";
        return res;
    }

    public nodo obtenerNodo(int pos) {
        if (pos <= 0 || pos > tamanio) {
            return null;
        }
        nodo aux = cabeza;
        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    public int obtenerMinima() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.getDato();
    }

    public int obtenerMaxima() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        return obtenerNodo(tamanio).getDato();
    }

    public double obtenerMediana() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        if (tamanio % 2 == 0) {
            int val1 = obtenerNodo(tamanio / 2).getDato();
            int val2 = obtenerNodo((tamanio / 2) + 1).getDato();
            return (val1 + val2) / 2.0;
        } else {
            return obtenerNodo((tamanio + 1) / 2).getDato();
        }
    }

    public int eliminarAlinicio() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista vacia");
        }
        int respuesta = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        tamanio--;
        return respuesta;
    }

    public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }
        if (cabeza.getDato() == x) {
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return true;
        }
        nodo aux = cabeza;
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getDato() == x) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                tamanio--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public int eliminarPosicion(int pos) {
        if (pos <= 0 || pos > tamanio) {
            throw new IllegalStateException("Posicion NO valida " + pos + ", Rango valido entre 1 hasta " + tamanio);
        }
        if (pos == 1) {
            return eliminarAlinicio();
        }
        nodo aux = obtenerNodo(pos - 1);
        nodo objetivo = aux.getSiguiente();
        int res = objetivo.getDato();
        aux.setSiguiente(objetivo.getSiguiente());
        tamanio--;
        return res;
    }

    public void corregir(int pos, int nuevoDato) {
        eliminarPosicion(pos);
        insertarOrdenado(nuevoDato);
    }

    public void eliminarInvalidas() {
        while (!estaVacia() && cabeza.getDato() < 1) {
            eliminarAlinicio();
        }
        if (estaVacia()) {
            return;
        }
        if (cabeza.getDato() > 300) {
            cabeza = null;
            tamanio = 0;
            return;
        }
        nodo aux = cabeza;
        int contador = 1;
        while (aux.getSiguiente() != null && aux.getSiguiente().getDato() <= 300) {
            aux = aux.getSiguiente();
            contador++;
        }
        aux.setSiguiente(null);
        tamanio = contador;
    }
}