package ch04_5;

import java.util.Scanner;

public class Baekjoon1018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        boolean[][] arr = new boolean[N][M];

        // true = W, false = B
        boolean[][] arr1 = new boolean[N][M];
        boolean[][] arr2 = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    arr1[i][j] = true;
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    arr1[i][j] = true;
                }
                if (i % 2 == 0 && j % 2 != 0) {
                    arr2[i][j] = true;
                }
                if (i % 2 != 0 && j % 2 == 0) {
                    arr2[i][j] = true;
                }
            }
        }

        int minDiff1 = Integer.MAX_VALUE;
        int minDiff2 = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'W') {
                    arr[i][j] = true;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int diff1 = 0;
                int diff2 = 0;
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if (arr[x][y] != arr1[x][y]) {
                            diff1++;
                        }
                        if (arr[x][y] != arr2[x][y]) {
                            diff2++;
                        }
                    }
                }
                if (minDiff1 > diff1) {
                    minDiff1 = diff1;
                }
                if (minDiff2 > diff2) {
                    minDiff2 = diff2;
                }
            }
        }

        System.out.println(Math.min(minDiff1, minDiff2));
    }
}
