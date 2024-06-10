package net.ms.main;

import net.ms.util.Alphabet;
import net.ms.util.MatrixOperations;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String message = "MENSAJE PRUEBA";
        int messageSize = message.length();
        final int mod = messageSize % 3;
        /*
          Para calcular el tamaño de la matriz 'M' verificamos si es multiplo de 3
          en caso contrario se suma 3 y se resta el valor de modulo
         */
        if (mod > 0) {
            messageSize += 3 - mod;
        }

        final int numberOfColumns = messageSize / 3;

        //Obtenemos la lista de alfabetos
        final List<String> alphabetList = Alphabet.getAlphabetList();
        //Instanciamos la matriz 'M'
        final int[][] matrixM = new int[3][numberOfColumns];
        //La matriz 'A' tendrá valores por defecto asignados (tiene que extraer de un archivo)
        final int[][] matrixA = {
                {2, 1, 2},
                {-1, 5, -1},
                {3, 1, 6}
        };
        //Matriz 'B' va a ser igual a matriz 'M' para términos de prueba copiamos el mismo
        final int[][] matrixB = MatrixOperations.getRandomMatrix(3, numberOfColumns);
        //Asignamos posiciones de caracteres en lista de alfabetos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                final int position = j + (i * numberOfColumns);
                if (position > (message.length() - 1)) {
                    matrixM[i][j] = 27;
                } else {
                    matrixM[i][j] = alphabetList.indexOf(message.split("")[position]);
                }
            }
        }

        MatrixOperations.printMatrix(matrixM, " ");

        System.out.println("-------------------------------------------------");

        final int[][] matrixC = MatrixOperations.getMatrixSum(MatrixOperations.getMatrixMultiplication(matrixA, matrixM), matrixB);

        MatrixOperations.printMatrix(matrixC, " ");
    }
}
