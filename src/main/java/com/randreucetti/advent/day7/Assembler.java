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
        if (commandArr.length == 3) {
            int v = 0;
            if (isNumeric(commandArr[0])) {
                v = Integer.parseInt(commandArr[0]);
            } else {
                if (wires.containsKey(commandArr[0])) {
                    v = wires.get(commandArr[0]);
                } else {
                    return;
                }
            }
            assign(v, commandArr[2]);
        } else if (commandArr[0].equals(NOT)) {
            int v = 0;
            if (isNumeric(commandArr[1])) {
                v = Integer.parseInt(commandArr[1]);
            } else {
                if (wires.containsKey(commandArr[1])) {
                    v = wires.get(commandArr[1]);
                } else {
                    return;
                }
            }
            not(v, commandArr[3]);
        } else {
            int v1 = 0;
            int v2 = 0;
            if (isNumeric(commandArr[0])) {
                v1 = Integer.parseInt(commandArr[0]);
            } else {
                if (wires.containsKey(commandArr[0])) {
                    v1 = wires.get(commandArr[0]);
                } else {
                    return;
                }
            }
            if (isNumeric(commandArr[2])) {
                v2 = Integer.parseInt(commandArr[2]);
            } else {
                if (wires.containsKey(commandArr[2])) {
                    v2 = wires.get(commandArr[2]);
                } else {
                    return;
                }
            }
            switch (commandArr[1]) {
            case AND: {
                and(v1, v2, commandArr[4]);
                break;
            }
            case OR: {
                or(v1, v2, commandArr[4]);
                break;
            }
            case LSHIFT: {
                lShift(v1, v2, commandArr[4]);
                break;
            }
            case RSHIFT: {
                rShift(v1, v2, commandArr[4]);
                break;
            }
            }
        }
    }

    private static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    private void assign(int v, String dest) {
        wires.put(dest, v);
    }

    private void and(int v1, int v2, String dest) {
        wires.put(dest, v1 & v2);
    }

    private void or(int v1, int v2, String dest) {
        wires.put(dest, v1 | v2);
    }

    private void not(int v, String dest) {
        wires.put(dest, ~v & 0xFFFF);
    }

    private void rShift(int v, int numBits, String dest) {
        wires.put(dest, v >> numBits);
    }

    private void lShift(int v, int numBits, String dest) {
        wires.put(dest, v << numBits);
    }

    public boolean containsKey(String key) {
        return wires.containsKey(key);
    }

    public int getValue(String key) {
        return wires.get(key);
    }

    public void insertVal(String key, int val) {
        wires.put(key, val);
    }
}
