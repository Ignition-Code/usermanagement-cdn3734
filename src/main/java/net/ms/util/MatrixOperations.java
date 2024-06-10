package net.ms.util;

import java.util.Random;

public class MatrixOperations {
    /**
     * @param matrixA matriz por defecto A
     * @param matrixM matriz que se genera de acuerdo al mensaje
     * @return matriz resultante entre la multiplicacion de 'A' por 'M'
     */
    public static int[][] getMatrixMultiplication(int[][] matrixA, int[][] matrixM) {
        final int colsM = matrixM[0].length;
        final int[][] result = new int[3][colsM];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colsM; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrixA[i][k] * matrixM[k][j];
                }
            }
        }

        return result;
    }

    /**
     * @param multiplication matriz que se obtiene de la multiplicacion de 'A' por 'M'
     * @param matrixB        matriz B
     * @return matriz resultante en 'C'
     */
    public static int[][] getMatrixSum(int[][] multiplication, int[][] matrixB) {
        int rows = multiplication.length;
        int cols = multiplication[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = multiplication[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    public static int[][] getRandomMatrix(int rows, int cols) {
        final int[][] result = new int[rows][cols];
        final Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = random.nextInt(100) + 1;
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix, String separator) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + separator);
            }
            System.out.println();
        }
    }

    public static void printMatrix(String[][] matrix, String separator) {
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell + separator);
            }
            System.out.println();
        }
    }
}
