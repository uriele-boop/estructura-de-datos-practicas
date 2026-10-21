/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad2.ordenamiento;

/**
 *
 * Angel Uriel Espnoza Alvarado 4C
 */
public class Burbuja {

    public static void main(String[] args) {
        int[] arrdesordenado = {1, 8, 9, 2, 5, 4};
        
        int[] arrordenados = {3, 4, 5, 6, 7};

        //Esta es la parte de pruebas del funcinamiento del metodo de ordenamiento de burbuja, empezando con el arreglo desordenado
        System.out.println(" Arreglo Desordenado");
        System.out.println("Antes del ordenamiento:");
        //Mostramos en pantalla dato por dato usando un for para el recorrido
        for (int i = 0; i < arrdesordenado.length; i++) {
            System.out.print(arrdesordenado[i] + " ");
        }
        System.out.println(); // Salto de linea

        // Se llama al metodo para que haga la funcion del ordenamiento
        ordenamientoBurbuja(arrdesordenado);
    
        System.out.println("Después del ordenamiento:");
        for (int i = 0; i < arrdesordenado.length; i++) {
            System.out.print(arrdesordenado[i] + " ");
        }
        System.out.println();
        //Es la parte ordenada donde usaremos la bandera para saber si el arreglo esta ordenado y no hcaer nada, o si esta desordenado y ordenarlos
        System.out.println(" Arreglo Ordenado");
        System.out.println("Antes del ordenamiento:");
        for (int i = 0; i < arrordenados.length; i++) {
            System.out.print(arrordenados[i] + " ");
        }
        System.out.println();
        //Llamamos al metodo
        ordenamientoBurbujaMejorado(arrordenados);

        System.out.println("Después del ordenamiento:");
        for (int i = 0; i < arrordenados.length; i++) {
            System.out.print(arrordenados[i] + " ");
        }
        System.out.println();     
    }//Finaliza el main
    
    public static void ordenamientoBurbuja(int[] arreglo) {
        // validación
        if (arreglo == null || arreglo.length <= 1) {
        return; 
        }
        //Para ordenarlos usamos el ciclo for anidado una para el recorrido y el otro hasta llegar el limite, usando una variable auxiliar que nos ayudad a almecnar los datos del arreglo para no perderlos
        for (int j = 0; j < arreglo.length; j++) {
            for (int i = 0; i < arreglo.length - 1; i++) {
                if (arreglo[i] > arreglo[i + 1]) {
                int aux = arreglo[i];
                arreglo[i] = arreglo[i + 1];
                arreglo[i + 1] = aux;
            }
        }
    }
}//Finaliza el primer metodo
    
    //Inicia la mejora del metodo, donde solo se agrega la bandera para saber si ordenamos el arreglo o no dependiendo si el arreglo esta ordenado
    public static void ordenamientoBurbujaMejorado(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
        return; 
        }

        for (int j = 0; j < arreglo.length; j++) {
            boolean intercambiado = false; // 2. Nuestra bandera inicia en false
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1]) {
                int aux = arreglo[i];
                arreglo[i] = arreglo[i + 1];
                arreglo[i + 1] = aux;
                intercambiado = true; // 3. Registramos el movimiento
            }
        }
        
        // 4. Revisamos si hubo movimientos al terminar el viaje
        if (intercambiado == false) { 
            break; // ¡Interrumpimos el ciclo j si ya está ordenado!
        }
    }
  }
}
