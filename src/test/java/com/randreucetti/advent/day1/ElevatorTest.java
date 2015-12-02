package com.randreucetti.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

public class ElevatorTest {
    @Test
    public void testDeliver() throws IOException {
        Reader bReader = new BufferedReader(new InputStreamReader(
                this.getClass().getClassLoader().getResourceAsStream("day1/input.txt")));
        Elevator.deliver(bReader);
        bReader.close();
    }
}
