package com.gmail.santiagoescobares06.mm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner join = new Scanner(System.in);
        int[][] A = null;
        int[][] B = null;

        for (int i = 0; i < 2; i++) {
            System.out.print("Ingresa el tamaño de la " + (i == 0 ? "primer" : "segunda") + " matriz: ");
            String[] sizeStr = join.nextLine().split("x");
            int rows = Integer.parseInt(sizeStr[0]);
            int columns = Integer.parseInt(sizeStr[1]);
            int[][] M = new int[rows][columns];

            System.out.println("Ingresa los números por filas:");
            for (int row = 0; row < rows; row++) {
                String[] numbers = join.nextLine().split(" ");
                for (int n = 0; n < numbers.length; n++) {
                    M[row][n] = Integer.parseInt(numbers[n]);
                }
            }

            if (i == 0) {
                A = M;
            } else {
                B = M;
            }
        }

        int[][] result = multiplyArrays(A, B);

        System.out.println("****************************************");
        System.out.println("Resultado: Matriz " + getRows(result) + "x" + getColumns(result));
        printArray(result);
    }

    static int[][] multiplyArrays(int[][] a, int[][] b) {
        int[][] result = new int[getRows(a)][getColumns(b)];
        int rRow = 0, rColumn = 0;

        for (int iA = 0; iA < getRows(a); iA++) {
            for (int jB = 0; jB < getColumns(b); jB++) {
                int cellResult = 0;

                for (int x = 0; x < getColumns(a); x++) {
                    int valueA = a[iA][x];
                    int valueB = b[x][jB];
                    cellResult += valueA * valueB;
                }
                result[rRow][rColumn] = cellResult;
                rColumn++;
            }
            rRow++;
            rColumn = 0;
        }
        return result;
    }

    static void printArray(int[][] array) {
        for (int j = 0; j < getColumns(array); j++) {
            for (int i = 0; i < getRows(array); i++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println("");
        }
    }

    static int getRows(int[][] array) {
        return array.length;
    }

    static int getColumns(int[][] array) {
        return array[0].length;
    }
}
