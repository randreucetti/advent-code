package com.randreucetti.advent.day7;

import java.util.HashMap;
import java.util.Map;

public class Assembler {
    private Map<String, Integer> wires;
    private final static String NOT = "NOT";
    private final static String OR = "OR";
    private final static String AND = "AND";
    private final static String RSHIFT = "RSHIFT";
    private final static String LSHIFT = "LSHIFT";

    public Assembler() {
        wires = new HashMap<String, Integer>();
    }

    public void processLine(String command) {
        String[] commandArr = command.split(" ");
        if (commandArr[0].equals(NOT)) {
            if (isNumeric(commandArr[0])) {
                int x = Integer.parseInt(commandArr[0]);
                wires.put(commandArr[3], ~x);
            } else {
                if(wires.containsKey(commandArr[0])) {
                    wires.put(commandArr[0], 0);
                } else {
                    
                }
                int x = wires.containsKey(commandArr[0]) ? wires.get(commandArr[0]) : 0;
            }
        } else {
            if (commandArr.length == 3) { //straight assign

            } else {

            }
        }
    }

    private static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
}
