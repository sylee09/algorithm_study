package ch04_5;

import java.util.Scanner;

public class Baekjoon9063 {

    public static void main(String[] args) {
        int minX = 10_000, minY = 10_000, maxX = -10_000, maxY = -10_000;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x > maxX) {
                maxX = x;
            }

            if (x < minX) {
                minX = x;
            }

            if (y > maxY) {
                maxY = y;
            }

            if (y < minY) {
                minY = y;
            }
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
