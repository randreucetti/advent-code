package com.randreucetti.advent.day2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class WrappingPaperTest {
    @Test
    public void testGetArea() {
        File file = new File(this.getClass().getClassLoader().getResource("day2/input.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            int totalArea = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] nums = line.split("x");
                totalArea += WrappingPaper.getArea(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]));
            }

            scanner.close();
            System.out.println("Total wrapping paper area: " + totalArea);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRibbon() {
        File file = new File(this.getClass().getClassLoader().getResource("day2/input.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            int totalRibbon = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] nums = line.split("x");
                totalRibbon += WrappingPaper.getRibbonLen(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2]));
            }

            scanner.close();
            System.out.println("Total ribbon length: " + totalRibbon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
