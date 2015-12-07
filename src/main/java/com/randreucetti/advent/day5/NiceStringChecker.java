package com.randreucetti.advent.day5;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class NiceStringChecker {
    private static final List<Character> VOWELS_LIST = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private static final List<String> FORBIDDEN_LIST = Arrays.asList("ab", "cd", "pq", "xy");

    private static final Pattern P2_PATTERN1 = Pattern.compile("(..).*\\1");
    private static final Pattern P2_PATTERN2 = Pattern.compile("(.).\\1");

    public static boolean isNiceP1(String input) {
		int numVowels = 0;
		char prev = 0;
		boolean twoInARow = false;
		boolean containsForbidden = false;
		for (int i = 0; i < input.length(); i++) {
			if (VOWELS_LIST.contains(input.charAt(i))) {
				numVowels++;
			}
			if (prev == input.charAt(i)) {
				twoInARow = true;
			}

			if (i < input.length() - 1) {
                if (FORBIDDEN_LIST.contains(input.substring(i, i + 2))) {
					containsForbidden = true;
				}
			}

			prev = input.charAt(i);
		}

        return numVowels >= 3 && twoInARow && !containsForbidden;
	}

    public static boolean isNiceP2(String input) {
        return P2_PATTERN1.matcher(input).find() && P2_PATTERN2.matcher(input).find();
    }
}
