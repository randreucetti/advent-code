package com.randreucetti.advent.day9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class RouteCalculatorTest {

    @Test
    public void testP1() {
        File file = new File(this.getClass().getClassLoader()
                .getResource("day9/input.txt").getFile());
        RouteCalculator rc = new RouteCalculator();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                rc.processRoute(line);
            }
            scanner.close();
            System.out.println("Shortest route length is: " + rc.getShortestRoute());
            System.out.println("Longest route length is: " + rc.getLongestRoute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
