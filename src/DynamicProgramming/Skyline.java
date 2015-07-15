package DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by myho on 7/8/15.
 */

/*
 * https://leetcode.com/problems/the-skyline-problem/
 * AWESOME explanation: http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
 */
public class Skyline {

    // aka strips in a skyline
    public static class KeyPoint {
        int x;
        int height;

        public KeyPoint(int x, int height) {
            this.x = x;
            this.height = height;
        }

        @Override
        public String toString() {
            return "KeyPoint{" +
                    "x=" + x +
                    ", height=" + height +
                    '}';
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<KeyPoint> result = getSkyline(buildings, 0, buildings.length - 1);
        return convert(result);
    }

    private static List<int[]> convert(List<KeyPoint> skyline) {
        List<int[]> result = new ArrayList<>();

        for(KeyPoint k : skyline) {
            System.out.println(k);
            result.add(new int[]{k.x, k.height});
        }

        return result;
    }

    private static LinkedList<KeyPoint> getSkyline(int[][] buildings, int low, int high) {
        // split each building into 2 strips
        if (low == high) {
            int[] building = buildings[low];
            LinkedList<KeyPoint> skyline = new LinkedList<>();

            // index 0 is x1, index 1 is x2, index 2 is height
            skyline.add(new KeyPoint(building[0], building[2]));
            skyline.add(new KeyPoint(building[1], 0));
            return skyline;
        }

        int mid = low + (high - low) / 2;

        LinkedList<KeyPoint> left = getSkyline(buildings, low, mid);
        LinkedList<KeyPoint> right = getSkyline(buildings, mid + 1, high);

        LinkedList<KeyPoint> result = mergeSkylines(left, right);

        return result;
    }

    private static LinkedList<KeyPoint> mergeSkylines(LinkedList<KeyPoint> skyline1, LinkedList<KeyPoint> skyline2) {
        LinkedList<KeyPoint> result = new LinkedList<>();

        int h1 = 0;
        int h2 = 0;

        while(!skyline1.isEmpty() && !skyline2.isEmpty()) {

            // Compare x coordinates of left sides of two
            // skylines and put the smaller one in result
            KeyPoint k1 = skyline1.getFirst();
            KeyPoint k2 = skyline2.getFirst();

            KeyPoint newKeypoint;
            if(k1.x < k2.height) {
                h1 = k1.height;

                int height = Math.max(h1, h2);

                newKeypoint = new KeyPoint(k1.x, height);
                skyline1.removeFirst();
            } else {
                h2 = k2.height;

                int height = Math.max(h1, h2);

                newKeypoint = new KeyPoint(k2.x, height);
                skyline2.removeFirst();
            }

            append(result, newKeypoint);
        }

        // If there are strips left in either skylines
        while(!skyline1.isEmpty()) {
            append(result, skyline1.removeFirst());
        }

        while(!skyline2.isEmpty()) {
            append(result, skyline2.removeFirst());
        }

        return result;
    }

    private static void append(LinkedList<KeyPoint> skyline, KeyPoint keyPoint)
    {
        // a keypoint is redundant if it has same
        // height or x as previous
        if(skyline.isEmpty()) {
            skyline.add(keyPoint);
        }

        KeyPoint previous = skyline.getLast();
        if(previous.x == keyPoint.x || previous.height == keyPoint.height) {
            return;
        }

        skyline.add(keyPoint);
    }

    public static void main(String[] args)
    {
        int[][] test = new int[][]{{1, 11, 5}, {2, 6, 7}, {3, 13, 9},
                {12, 7, 16}, {14, 3, 25}, {19, 18, 22},
                {23, 13, 29}, {24, 4, 28}};

        getSkyline(test);

    }
}
