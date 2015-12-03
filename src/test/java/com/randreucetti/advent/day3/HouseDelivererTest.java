package com.randreucetti.advent.day3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class HouseDelivererTest {
    @Test
    public void testGetNumHouses() {
        File file = new File(this.getClass().getClassLoader().getResource("day3/input.txt").getFile());
        HouseDeliverer hd = new HouseDeliverer(1);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    hd.move(chars[i]);
                }
            }

            scanner.close();
            System.out.println("Number houses visited: " + hd.getNumHousesVisited());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNumHousesUsingRobo() {
        File file = new File(this.getClass().getClassLoader().getResource("day3/input.txt").getFile());
        HouseDeliverer hd = new HouseDeliverer(2);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    hd.move(chars[i]);
                }
            }

            scanner.close();
            System.out.println("Number houses visited (Mark 2): " + hd.getNumHousesVisited());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
