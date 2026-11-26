/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad3.listasDobles;

import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class Main {

    // Muestra un menú en consola para probar los métodos de la lista doble
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        listaDoble lista = new listaDoble();
        int opcion = 1;
        int dato, pos;

        while (opcion != 0) {
            System.out.println("\nMENU LISTA DOBLE");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posicion");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar ultimo");
            System.out.println("7. Eliminar en posicion");
            System.out.println("8. Eliminar por valor");
            System.out.println("9. Buscar");
            System.out.println("10. Actualizar");
            System.out.println("11. Imprimir lista");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    lista.insertarAlInicio(teclado.nextInt());
                    break;

                case 2:
                    System.out.print("Dato: ");
                    lista.insertarAlFinal(teclado.nextInt());
                    break;

                case 3:
                    System.out.print("Posicion: ");
                    pos = teclado.nextInt();
                    if (pos >= 1 && pos <= lista.getTamanio() + 1) {
                        System.out.print("Dato: ");
                        dato = teclado.nextInt();
                        lista.insertarEnPosicion(pos, dato);
                    } else {
                        System.out.println("Posicion no valida");
                    }
                    break;

                case 4:
                    System.out.print("Dato: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    break;

                case 5:
                    if (!lista.estaVacia()) {
                        System.out.println("Eliminado: " + lista.eliminarInicio());
                    } else {
                        System.out.println("Lista vacia");
                    }
                    break;

                case 6:
                    if (lista.eliminarUltimo()) {
                        System.out.println("Ultimo eliminado");
                    } else {
                        System.out.println("Lista vacia");
                    }
                    break;

                case 7:
                    System.out.print("Posicion: ");
                    pos = teclado.nextInt();
                    if (pos >= 1 && pos <= lista.getTamanio()) {
                        System.out.println("Eliminado: " + lista.eliminarEnPosicion(pos));
                    } else {
                        System.out.println("Posicion no valida");
                    }
                    break;

                case 8:
                    System.out.print("Valor a eliminar: ");
                    if (lista.eliminarPorValor(teclado.nextInt())) {
                        System.out.println("Eliminado");
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;

                case 9:
                    System.out.print("Valor a buscar: ");
                    if (lista.buscar(teclado.nextInt())) {
                        System.out.println("Si existe");
                    } else {
                        System.out.println("No existe");
                    }
                    break;

                case 10:
                    System.out.print("Posicion: ");
                    pos = teclado.nextInt();
                    if (pos >= 1 && pos <= lista.getTamanio()) {
                        System.out.print("Nuevo dato: ");
                        dato = teclado.nextInt();
                        lista.actualizar(pos, dato);
                    } else {
                        System.out.println("Posicion no valida");
                    }
                    break;

                case 11:
                    System.out.println(lista.toString());
                    System.out.println("Tamanio: " + lista.getTamanio());
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}
