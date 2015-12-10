package com.randreucetti.advent.day10;

public class LookSayUtil {
    public static String getOutputString(String input) {
        char previous = '-';
        int charCounter = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length()) {
                sb.append(charCounter + "" + previous);
                break;
            }
            char c = input.charAt(i);
            if (c != previous && previous != '-') {
                sb.append(charCounter + "" + previous);
                charCounter = 0;
            }
            charCounter++;
            previous = c;
        }
        return sb.toString();
    }
}
