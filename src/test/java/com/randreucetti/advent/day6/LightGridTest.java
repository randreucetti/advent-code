package com.randreucetti.advent.day6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class LightGridTest {
    @Test
    public void test() {
        File file = new File(this.getClass().getClassLoader()
                .getResource("day6/input.txt").getFile());
        LightGrid lg = new LightGrid();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lg.processCommand(line);
            }
            scanner.close();

            System.out.println("Num alighted: " + lg.getNumLit());
            System.out.println("Total Brightness: " + lg.getTotalBrightness());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
