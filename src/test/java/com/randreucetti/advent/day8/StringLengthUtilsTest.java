package com.randreucetti.advent.day8;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class StringLengthUtilsTest {
    @Test
    public void testP1() {
        File file = new File(this.getClass().getClassLoader()
                .getResource("day8/input.txt").getFile());
        int totalLen = 0;
        int strLen = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int totalLineLen = StringLengthUtils.getCodeLength(line);
                int strLineLen = StringLengthUtils.getInnerStringLength(line);
                totalLen += totalLineLen;
                strLen += strLineLen;
            }
            scanner.close();
            System.out.println("Difference is (P1): " + (totalLen - strLen));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testP2() {
        File file = new File(this.getClass().getClassLoader()
                .getResource("day8/input.txt").getFile());
        int totalLen = 0;
        int encLen = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int totalLineLen = StringLengthUtils.getCodeLength(line);
                int encLineLen = StringLengthUtils.getEncodedLength(line);
                totalLen += totalLineLen;
                encLen += encLineLen;
            }
            scanner.close();
            System.out.println("Difference is (P2): " + (encLen - totalLen));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
