package com.randreucetti.advent.day8;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringLengthUtils {
    public static int getCodeLength(String input) {
        return input.length();
    }

    public static int getInnerStringLength(String input) {
        int codeLength = input.length();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == 34) { // if quotation
                codeLength--;
            } else if (curChar == 92) {  // if slash
                codeLength--;
                curChar = input.charAt(i + 1);
                if (curChar == 120) { // if hex
                    codeLength -= 2;
                    i += 3;
                } else {
                    i++;
                }
            }
        }
        return codeLength;
    }

    public static int getEncodedLength(String input) {
        return StringEscapeUtils.escapeJava(input).length() + 2;
    }
}
