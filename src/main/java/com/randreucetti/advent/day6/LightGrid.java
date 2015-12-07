package com.randreucetti.advent.day6;

public class LightGrid {
    private boolean[][] grid;
    private int[][] brightnessGrid;
    private static final String TURN = "turn";
    private static final String ON = "on";

    public LightGrid() {
        grid = new boolean[1000][1000];
        brightnessGrid = new int[1000][1000];
    }

    public void processCommand(String command) {
        String[] inputArr = command.split(" ");
        if (inputArr[0].equals(TURN)) {
            String[] p1 = inputArr[2].split(",");
            String[] p2 = inputArr[4].split(",");
            int x1 = Integer.parseInt(p1[0]);
            int y1 = Integer.parseInt(p1[1]);
            int x2 = Integer.parseInt(p2[0]);
            int y2 = Integer.parseInt(p2[1]);
            if (inputArr[1].equals(ON)) {
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        grid[x][y] = true;
                        brightnessGrid[x][y]++;
                    }
                }
            } else { //off
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        grid[x][y] = false;
                        if (brightnessGrid[x][y] != 0) {
                            brightnessGrid[x][y]--;
                        }
                    }
                }
            }
        } else { //toggle
            String[] p1 = inputArr[1].split(",");
            String[] p2 = inputArr[3].split(",");
            int x1 = Integer.parseInt(p1[0]);
            int y1 = Integer.parseInt(p1[1]);
            int x2 = Integer.parseInt(p2[0]);
            int y2 = Integer.parseInt(p2[1]);
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    grid[x][y] = !grid[x][y];
                    brightnessGrid[x][y] += 2;
                }
            }
        }
    }

    public int getNumLit() {
        int counter = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (grid[x][y]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int getTotalBrightness() {
        int totalBrightness = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                totalBrightness += brightnessGrid[x][y];
            }
        }
        return totalBrightness;
    }
}
