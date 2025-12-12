package ch05;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15662 {
    static LinkedList<LinkedList<Integer>> gears = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String line = sc.nextLine();
            gears.add(new LinkedList<>());

            for (int j = 0; j < 8; j++) {
                gears.get(i).add(Integer.valueOf(String.valueOf(line.charAt(j))));
            }
        }

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int gear = sc.nextInt() - 1;
            int dirInt = sc.nextInt();
            boolean dir;
            if (dirInt == 1) {
                dir = true;
            } else {
                dir = false;
            }
            rotateGearLeft(gear, dir);
            if (dir) {
                int first = gears.get(gear).poll();
                gears.get(gear).offer(first);
            } else {
                int last = gears.get(gear).pollLast();
                gears.get(gear).offerFirst(last);
            }
            rotateGearRight(gear, dir);
        }

        int ans = 0;
        for (LinkedList<Integer> gear : gears) {
            Integer first = gear.get(0);
            if (first == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void rotateGearLeft(int gear, boolean dir) {
        int leftGear = gear - 1;

        int lMagnetic = gears.get(gear).get(6);

        if (leftGear >= 0) {
            int leftGearRMagnetic = gears.get(leftGear).get(2);
            if (leftGearRMagnetic != lMagnetic) {
                rotateGearLeft(leftGear, !dir);
            }
        }

        if (dir) {
            int last = gears.get(gear).pollLast();
            gears.get(gear).offerFirst(last);
        } else {
            int first = gears.get(gear).poll();
            gears.get(gear).offer(first);
        }
    }

    static void rotateGearRight(int gear, boolean dir) {
        int rightGear = gear + 1;

        int rMagnetic = gears.get(gear).get(2);

        if (rightGear < gears.size()) {
            int rightGearLMagnetic = gears.get(rightGear).get(6);
            if (rightGearLMagnetic != rMagnetic) {
                rotateGearRight(rightGear, !dir);
            }
        }

        if (dir) {
            int last = gears.get(gear).pollLast();
            gears.get(gear).offerFirst(last);
        } else {
            int first = gears.get(gear).poll();
            gears.get(gear).offer(first);
        }
    }
}
