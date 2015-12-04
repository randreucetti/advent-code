package com.randreucetti.advent.day3;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class HouseDeliverer {

    private Point[] currentHouses;
    private Set<Point> housesVisited;
    int index;

    public HouseDeliverer(int numDeliverers) {
        currentHouses = new Point[numDeliverers];
        housesVisited = new HashSet<Point>();
        for (int i = 0; i < currentHouses.length; i++) {
            currentHouses[i] = new Point(0, 0);
            housesVisited.add((Point) currentHouses[i].clone());
        }
        index = 0;
    }

    public void move(char c) {
        index = index % currentHouses.length;
        switch (c) {
        case '<':
            currentHouses[index].x--;
            break;
        case '>':
            currentHouses[index].x++;
            break;
        case '^':
            currentHouses[index].y++;
            break;
        case 'v':
            currentHouses[index].y--;
            break;
        }
        housesVisited.add((Point) currentHouses[index].clone());
        index++;
    }

    public int getNumHousesVisited() {
        return housesVisited.size();
    }
}
