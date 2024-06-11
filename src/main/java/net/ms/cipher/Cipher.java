package net.ms.cipher;

import net.ms.util.MatrixOperations;

public class Cipher {
    public static int[][] encrypt(int[][] multiplication, int[][] matrixB) {
        return MatrixOperations.getMatrixSum(multiplication, matrixB);
    }

    public static double[][] decrypt(double[][] inverse, int[][] subtract) {
        return MatrixOperations.getMatrixMultiplication(inverse, subtract);
    }
}
