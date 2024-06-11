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

    public static double[][] getMatrixMultiplication(double[][] matrixA, int[][] matrixM) {
        final int colsM = matrixM[0].length;
        final double[][] result = new double[3][colsM];
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

    /**
     *
     * @param matrixA matriz por defecto A
     * @return retorna matriz 'A' invertida
     */
    public static double[][] getInvertedMatrix(int[][] matrixA) {
        int n = matrixA.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Crear la matriz aumentada [matrix | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrixA[i][j];
            }
            augmentedMatrix[i][i + n] = 1;
        }

        // Aplicar el método de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Buscar el elemento de la diagonal más grande
            double maxElement = augmentedMatrix[i][i];
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(augmentedMatrix[k][i]) > Math.abs(maxElement)) {
                    maxElement = augmentedMatrix[k][i];
                    maxRow = k;
                }
            }

            // Intercambiar filas si es necesario
            if (maxRow != i) {
                double[] temp = augmentedMatrix[i];
                augmentedMatrix[i] = augmentedMatrix[maxRow];
                augmentedMatrix[maxRow] = temp;
            }

            // Hacer que el elemento de la diagonal sea 1
            double diagElement = augmentedMatrix[i][i];
            if (diagElement == 0) {
                return null; // La matriz no es invertible
            }
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= diagElement;
            }

            // Hacer que los demás elementos de la columna sean 0
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Extraer la matriz inversa
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverse;
    }

    public static int[][] getMatrixSubtraction(int[][] matrixC, int[][] matrixB) {
        int cols = matrixC[0].length;
        int[][] result = new int[3][cols];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixC[i][j] - matrixB[i][j];
            }
        }

        return result;
    }

    /**
     *
     * @param rows determina la cantidad de filas
     * @param cols determina la cantidad de columnas
     * @return matriz con numeros aleatorios con propósitos de prueba
     */
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

    public static void printMatrix(double[][] matrix, String separator) {
        for (double[] row : matrix) {
            for (double cell : row) {
                System.out.print(cell + separator);
            }
            System.out.println();
        }
    }
}
