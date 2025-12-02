package ch04_5;

import java.util.Scanner;

public class Baekjoon3009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[1001];
        int[] y = new int[1001];

        for (int i = 0; i < 3; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            x[X]++;
            y[Y]++;
        }

        int[] ans = new int[2];
        for (int i = 1; i <= 1000; i++) {
            if (x[i] == 1) {
                ans[0] = i;
            }
            if (y[i] == 1) {
                ans[1] = i;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
