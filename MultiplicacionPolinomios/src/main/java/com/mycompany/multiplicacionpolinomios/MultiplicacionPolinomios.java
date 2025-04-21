/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.multiplicacionpolinomios;

import java.util.Scanner;
/**
 *
 * @author Rafael
 */
public class MultiplicacionPolinomios {

    // Método para multiplicar recursivamente
    public static int[] multiplicarRecursivo(int[] A, int[] B, int gradoA, int gradoB) {
        int[] resultado = new int[gradoA + gradoB + 1];
        multiplicarTermino(A, B, resultado, 0, gradoA, gradoB);
        return resultado;
    }

    // Método auxiliar para manejar el primer índice del primer polinomio
    private static void multiplicarTermino(int[] A, int[] B, int[] resultado, int i, int gradoA, int gradoB) {
        if (i > gradoA) return; // caso base
        multiplicarInterno(A, B, resultado, i, 0, gradoB); // multiplicar A[i] por todos los B[j]
        multiplicarTermino(A, B, resultado, i + 1, gradoA, gradoB); // avanzar al siguiente término de A
    }

    // Método recursivo para multiplicar A[i] * B[j]
    private static void multiplicarInterno(int[] A, int[] B, int[] resultado, int i, int j, int gradoB) {
        if (j > gradoB) return; // caso base
        resultado[i + j] += A[i] * B[j]; // sumamos el producto en la posición correspondiente
        multiplicarInterno(A, B, resultado, i, j + 1, gradoB); // avanzar al siguiente término de B
    }

    // Método para imprimir el polinomio
    public static void imprimirPolinomio(int[] pol) {
        for (int i = pol.length - 1; i >= 0; i--) {
            if (pol[i] != 0) {
                if (i != pol.length - 1 && pol[i] > 0) System.out.print(" + ");
                System.out.print(pol[i]);
                if (i > 0) System.out.print("x^" + i);
            }
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Grado del primer polinomio: ");
        int gradoA = sc.nextInt();
        int[] A = new int[gradoA + 1];
        System.out.println("Coeficientes del primer polinomio:");
        for (int i = gradoA; i >= 0; i--) {
            System.out.print("Coeficiente x^" + i + ": ");
            A[i] = sc.nextInt();
        }

        System.out.print("Grado del segundo polinomio: ");
        int gradoB = sc.nextInt();
        int[] B = new int[gradoB + 1];
        System.out.println("Coeficientes del segundo polinomio:");
        for (int i = gradoB; i >= 0; i--) {
            System.out.print("Coeficiente x^" + i + ": ");
            B[i] = sc.nextInt();
        }

        int[] resultado = multiplicarRecursivo(A, B, gradoA, gradoB);

        System.out.println("Resultado de la multiplicación:");
        imprimirPolinomio(resultado);
    }
}
