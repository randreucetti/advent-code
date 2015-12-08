package com.randreucetti.advent.day7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class AssemblerTest {
    @Test
    public void testP1() {
        File file = new File(this.getClass().getClassLoader()
                .getResource("day7/input.txt").getFile());
        Assembler assembler = new Assembler();
        while (!assembler.containsKey("a")) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    assembler.processLine(line);
                }
                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Value of a is (P1) " + assembler.getValue("a"));
    }

    @Test
    public void testP2() {
        File file = new File(this.getClass().getClassLoader()
                .getResource("day7/mod_input.txt").getFile());
        Assembler assembler = new Assembler();
        while (!assembler.containsKey("a")) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    assembler.processLine(line);
                }
                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Value of a is (P2) " + assembler.getValue("a"));
    }
}
