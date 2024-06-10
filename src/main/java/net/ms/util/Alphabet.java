package net.ms.util;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    public static List<String> getAlphabetList() {
        final List<String> alphabetList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (i == 14) {
                alphabetList.add("Ñ");
            }
            alphabetList.add(String.valueOf((char) ('A' + i)));
        }
        alphabetList.add(" ");
        return alphabetList;
    }
}
