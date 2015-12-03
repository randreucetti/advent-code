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
            housesVisited.add(new Point(0, 0));
        }
        index = 0;
    }

    public void move(char c) {
        index = index % currentHouses.length;
        Point currentHouse = currentHouses[index];
        switch (c) {
        case '<':
            currentHouse.x--;
            break;
        case '>':
            currentHouse.x++;
            break;
        case '^':
            currentHouse.y++;
            break;
        case 'v':
            currentHouse.y--;
            break;
        }
        housesVisited.add(new Point(currentHouse.x, currentHouse.y));
        index++;
    }

    public int getNumHousesVisited() {
        return housesVisited.size();
    }
}
