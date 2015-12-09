package com.randreucetti.advent.day9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.iterators.PermutationIterator;

public class RouteCalculator {
    private Map<String, Map<String, Integer>> routes;
    private Set<String> nodeNames;

    public RouteCalculator() {
        routes = new HashMap<String, Map<String, Integer>>();
        nodeNames = new HashSet<String>();
    }

    public void processRoute(String route) {
        String[] routeArr = route.split(" ");
        if(!routes.containsKey(routeArr[0])){
            routes.put(routeArr[0], new HashMap<String, Integer>());
            nodeNames.add(routeArr[0]);
        }
        routes.get(routeArr[0]).put(routeArr[2], Integer.parseInt(routeArr[4]));

        if(!routes.containsKey(routeArr[2])){
            routes.put(routeArr[2], new HashMap<String, Integer>());
            nodeNames.add(routeArr[2]);
        }
        routes.get(routeArr[2]).put(routeArr[0], Integer.parseInt(routeArr[4]));
    }

    public int getShortestRoute() {
        PermutationIterator<String> permIter = new PermutationIterator<String>(nodeNames);
        Integer shortest = null;
        while (permIter.hasNext()) {
            List<String> route = permIter.next();
            String prev = null;
            int routeLength = 0;
            for (String node : route) {
                if (prev != null) {
                    routeLength += routes.get(prev).get(node);
                }
                prev = node;
            }
            if (shortest == null || routeLength < shortest) {
                shortest = routeLength;
                //                System.out.println(route + " -> " + shortest);
            }
        }
        return shortest;
    }

    public int getLongestRoute() {
        PermutationIterator<String> permIter = new PermutationIterator<String>(nodeNames);
        Integer longest = null;
        while (permIter.hasNext()) {
            List<String> route = permIter.next();
            String prev = null;
            int routeLength = 0;
            for (String node : route) {
                if (prev != null) {
                    routeLength += routes.get(prev).get(node);
                }
                prev = node;
            }
            if (longest == null || routeLength > longest) {
                longest = routeLength;
                //                System.out.println(route + " -> " + longest);
            }
        }
        return longest;
    }
}
