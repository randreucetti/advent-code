package com.randreucetti.advent.day5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;


public class NiceStringCheckerTest {
	@Test
	public void testGetNumNiceStrings() {
		File file = new File(this.getClass().getClassLoader()
				.getResource("day5/input.txt").getFile());
		int counter = 0;
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(NiceStringChecker.isNice(line)){
					counter++;
				}
			}

			scanner.close();
			System.out.println("Number nice strings: "
					+ counter);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
