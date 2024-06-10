package net.ms.main;

import net.ms.util.Alphabet;

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

        final List<String> alphabetList = Alphabet.getAlphabetList();

        for (String c : alphabetList)
            System.out.println(c);

        System.out.println(messageSize);
    }
}
