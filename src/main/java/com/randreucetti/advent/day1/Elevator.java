package com.randreucetti.advent.day1;

import java.io.IOException;
import java.io.Reader;

/**
 * @see <a href="http://adventofcode.com/day/1<">http://adventofcode.com/day/1</a>
 */
public class Elevator {
    public static void deliver(Reader bReader) throws IOException {
        int floor = 0;
        int c;
        int counter = 1;
        boolean enteredBasement = false;
        while ((c = bReader.read()) != -1) {
            if ((char) c == '(') {
                floor++;
            } else {
                floor--;
            }
            if (floor == -1 && !enteredBasement) {
                enteredBasement = true;
                System.out.println("Entering basement: " + counter);
            }
            counter++;
        }
        System.out.println("Finish on floor: " + floor);
    }
}
