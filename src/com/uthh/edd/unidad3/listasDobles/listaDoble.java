/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad3.listasDobles;

/**
 *
 * Angel Uriel 4C
 */
public class listaDoble {
    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;
    
    public listaDoble(){
        tamanio=0;
        cabeza=null;
        cola=null;
    }
    
    public boolean estaVacia(){
        if (cabeza==null && cola==null) {
            return true;
        }else{
            return false;
        }
    }

    public int getTamanio() {
        return tamanio;
    }
    
    public boolean buscar(int dato) {
        nodoDoble aux = cabeza;
        while (aux!= null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    @Override
    public String toString() {
        String res ="NULL";
        nodoDoble aux = cabeza;
        while (aux != null) {
            res = res + "<--[" + aux.getDato() + "]-->";
            aux = aux.getSiguiente();
        }
        res = res + "NULL";
        return res;
    }
    
    public nodoDoble obtenerNodo(int pos) {
        if (pos <= 0 || pos > tamanio) {
            return null;
        }
        nodoDoble aux = cabeza;
        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
     public void actualizar(int pos, int dato)
    {
        nodoDoble referencia = obtenerNodo(pos); 
        referencia.setDato(dato);
    }
    
    public void insertarAlInicio(int dato){
        nodoDoble nuevo=new nodoDoble(dato);
        //Csso 1 en caso de que la lista este vacia
        if (estaVacia()) {
           // cabeza=nuevo;
            cola=nuevo;
           // tamanio++;
        }else{//En caso de que la lista no este vacia 
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
            
        }
        cabeza=nuevo;
        tamanio++;
        
    }
    
    public void insertarAlFinal(int dato){
        //Creamos el nodo
        nodoDoble nuevo=new nodoDoble(dato);
        if (estaVacia()) {
            cabeza=nuevo;
        }else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }
        cola=nuevo;
        tamanio++;
    }
    
   //Insertar un nodo en cualquier posicion
    public void insertarEnPosicion(int pos, int dato){
        if (pos<=0 || pos>tamanio+1) {
            throw new IllegalStateException("Posicion no valida: "+ pos+ "rango valido de 1 al"+(tamanio+1));
        }
        if (pos==1) {
            insertarAlInicio(dato);
            return;
        }
        if (pos==tamanio+1) {
            insertarAlFinal(dato);
            return;
        }
        nodoDoble anterior=obtenerNodo(pos-1);
        nodoDoble siguiente=anterior.getSiguiente();
        //constructor
        nodoDoble nuevo=new nodoDoble(dato);
        
        nuevo.setSiguiente(siguiente);
        nuevo.setAnterior(anterior);
        anterior.setSiguiente(nuevo);
        siguiente.setAnterior(nuevo);
        tamanio++;
    }
    
    //Insertar ordenadamente cabeza, cola y enalces dobles
    public void insertarOrdenado(int dato){
        if (estaVacia()||dato<=cabeza.getDato()) {
            insertarAlInicio(dato);
            return;
        }
        if (dato>=cola.getDato()) {
            insertarAlFinal(dato);
            return;
        }
        nodoDoble aux=cabeza;
        while(aux.getSiguiente()!=null && dato>aux.getSiguiente().getDato()){
            aux=aux.getSiguiente();
        }
        nodoDoble siguiente = aux.getSiguiente();
        nodoDoble nuevo = new nodoDoble(dato);

        nuevo.setSiguiente(siguiente);
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        siguiente.setAnterior(nuevo);
        tamanio++;
    }
    
    // Eliminar el primer nodo
    public int eliminarInicio() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista esta vacia...");
        }
        int dato = cabeza.getDato();
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
           cabeza = cabeza.getSiguiente();
           cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }
    
    //Eliminar el ultimo nodo
    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }
     //Eliminar por posicion
     public int eliminarEnPosicion(int pos){
         if (pos<=0||pos>tamanio) {
             throw new IllegalStateException("Posición no válida: " + pos + ", rango válido del 1 al " + tamanio);
         }
         if (pos==1) {
             return eliminarInicio();
         }
         if (pos==tamanio) {
             int dato=cola.getDato();
             eliminarUltimo();
             return dato;
         }
         nodoDoble objetivo = obtenerNodo(pos);
        int dato = objetivo.getDato();
        nodoDoble anterior = objetivo.getAnterior();
        nodoDoble siguiente = objetivo.getSiguiente();

        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);
        tamanio--;
        return dato;
     }
    
     //Eliminar por el valo que guarda el nodo
   public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }
        if (cabeza.getDato() == x) {
            eliminarInicio();
            return true;
        }
        nodoDoble aux = cabeza.getSiguiente();
        while (aux != null) {
            if (aux.getDato() == x) {
                if (aux == cola) {
                    return eliminarUltimo();
                }
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
                tamanio--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
}