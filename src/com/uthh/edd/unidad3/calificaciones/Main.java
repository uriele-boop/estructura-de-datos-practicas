/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad3.calificaciones;

/**
 *
 * Autor: Angel Uriel Espinoza
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        listaEnlazada lista = new listaEnlazada();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== SISTEMA DE CALIFICACIONES =====");
            System.out.println("1. Agregar calificación");
            System.out.println("2. Imprimir lista");
            System.out.println("3. Consultar por posición");
            System.out.println("4. Ver estadísticas (mínima, máxima y mediana)");
            System.out.println("5. Corregir calificación");
            System.out.println("6. Eliminar calificaciones inválidas (fuera de 1-300)");
            System.out.println("7. Buscar calificación");
            System.out.println("8. Ver cuántos estudiantes entregaron");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la calificación: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    break;
                case 2:
                    System.out.println(lista.Tostring());
                    break;
                case 3:
                    System.out.print("Ingresa la posición: ");
                    int pos = teclado.nextInt();
                    nodo encontrado = lista.obtenerNodo(pos);
                    if (encontrado == null) {
                        System.out.println("Posición no válida");
                    } else {
                        System.out.println("Calificación: " + encontrado.getDato());
                    }
                    break;
                case 4:
                    if (lista.estaVacia()) {
                        System.out.println("La lista está vacía, no hay estadísticas.");
                    } else {
                        System.out.println("Mínima: " + lista.obtenerMinima());
                        System.out.println("Máxima: " + lista.obtenerMaxima());
                        System.out.println("Mediana: " + lista.obtenerMediana());
                    }
                    break;
                case 5:
                    System.out.print("Ingresa la posición a corregir: ");
                    int posCorregir = teclado.nextInt();
                    if (posCorregir >= 1 && posCorregir <= lista.getTamanio()) {
                        System.out.print("Ingresa la nueva calificación: ");
                        int nuevaCalif = teclado.nextInt();
                        lista.corregir(posCorregir, nuevaCalif);
                        System.out.println("Calificación corregida");
                    } else {
                        System.out.println("Posición no válida");
                    }
                    break;
                case 6:
                    lista.eliminarInvalidas();
                    System.out.println("Se eliminaron las calificaciones inválidas");
                    break;
                case 7:
                    System.out.print("Ingresa la calificación a buscar: ");
                    int califBuscar = teclado.nextInt();
                    if (lista.buscar(califBuscar)) {
                        System.out.println("Sí hay alguien con esa calificación");
                    } else {
                        System.out.println("Nadie sacó esa calificación");
                    }
                    break;
                case 8:
                    System.out.println("Total de estudiantes que entregaron: " + lista.getTamanio());
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }
        teclado.close();
    }
}