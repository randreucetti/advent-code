package com.randreucetti.advent.day4;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class AdventCoinsTest {
    @Test
    public void testGetLowestNumberP1() throws NoSuchAlgorithmException {
        String pattern = "00000";
        int number = AdventCoins.getLowestNumber("yzbqklnj", pattern);
        System.out.println(pattern + ".... created by appending: " + number);
    }

    @Test
    public void testGetLowestNumberP2() throws NoSuchAlgorithmException {
        String pattern = "000000";
        int number = AdventCoins.getLowestNumber("yzbqklnj", pattern);
        System.out.println(pattern + ".... created by appending: " + number);
    }
}
