package com.randreucetti.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class NiceStringChecker {
	public static final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };
	public static final List<Character> VOWELS_LIST = new ArrayList<Character>();

	public static final String[] FORBIDDEN = { "ab", "cd", "pq", "xy" };
	public static final List<String> FORBIDDEN_LIST = new ArrayList<String>();

	public static boolean isNice(String input) {
		int numVowels = 0;
		char prev = 0;
		boolean twoInARow = false;
		boolean containsForbidden = false;
		for (int i = 0; i < input.length(); i++) {
			if (VOWELS_LIST.contains(input.charAt(i))) {
				numVowels++;
				if (numVowels == 3) {
					return true;
				}
			}
			if (prev == input.charAt(i)) {
				twoInARow = true;
			}

			if (i < input.length() - 1) {
				if (FORBIDDEN_LIST.contains(input.substring(i, i + 1))) {
					containsForbidden = true;
				}
			}

			prev = input.charAt(i);
		}
		
		return numVowels >=3 &&twoInARow && !containsForbidden;
	}
}
