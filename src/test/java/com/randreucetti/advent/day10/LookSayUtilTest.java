package com.randreucetti.advent.day10;

import org.junit.Test;

public class LookSayUtilTest {
    @Test
    public void testP1() {
        String sequence = "3113322113";
        for (int i = 0; i < 40; i++) {
            sequence = LookSayUtil.getOutputString(sequence);
        }
        System.out.println("Looksay (P1): " + sequence.length());
    }

    @Test
    public void testP2() {
        String sequence = "3113322113";
        for (int i = 0; i < 50; i++) {
            sequence = LookSayUtil.getOutputString(sequence);
        }
        System.out.println("Looksay (P2): " + sequence.length());
    }
}
