package ch05;

import java.util.Scanner;

public class Baekjoon15662 {
    static int T;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        boolean[][] gears = new boolean[T][8];

        for (int num = 0; num < T; num++) {
            String line = sc.nextLine();
            for (int i = 0; i < 8; i++) {
                int n = Integer.parseInt(String.valueOf(line.charAt(i)));
                // N극0, S극 1
                gears[num][i] = n == 1;
            }
        }
        int K = sc.nextInt();

        // 회전
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            int dir = sc.nextInt();
            rotate(gears, num - 1, dir);
        }

        int ans = 0;
        for (int i = 0; i < T; i++) {
            if (gears[i][0]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void rotate(boolean[][] gears, int num, int dir) {
        // 왼쪽 톱니바퀴 이동
        if (num - 1 >= 0 && gears[num][6] != gears[num - 1][2]) {
            if (dir == 1) {
                rotateLeft(gears, num - 1, -1);
            } else {
                rotateLeft(gears, num - 1, 1);
            }
        }
        // 오른쪽 톱니바퀴 이동
        if (num + 1 < T && gears[num][2] != gears[num + 1][6]) {
            if (dir == 1) {
                rotateRight(gears, num + 1, -1);
            } else {
                rotateRight(gears, num + 1, 1);
            }
        }

        // 현재 톱니바퀴 이동
        if (dir == 1) {
            boolean cur = gears[num][0];
            gears[num][0] = gears[num][7];

            for (int i = 1; i <= 7; i++) {
                boolean next = gears[num][i];
                gears[num][i] = cur;
                cur = next;
            }
        }else {
            boolean cur = gears[num][7];
            gears[num][7] = gears[num][0];

            for (int i = 6; i >= 0; i--) {
                boolean next = gears[num][i];
                gears[num][i] = cur;
                cur = next;
            }
        }
    }

    private static void rotateLeft(boolean[][] gears, int num, int dir) {
        if (num - 1 >= 0 && gears[num][6] != gears[num - 1][2]) {
            if (dir == 1) {
                rotateLeft(gears, num - 1, -1);
            } else {
                rotateLeft(gears, num - 1, 1);
            }
        }
        if (dir == 1) {
            boolean cur = gears[num][0];
            gears[num][0] = gears[num][7];

            for (int i = 1; i <= 7; i++) {
                boolean next = gears[num][i];
                gears[num][i] = cur;
                cur = next;
            }
        }else {
            boolean cur = gears[num][7];
            gears[num][7] = gears[num][0];

            for (int i = 6; i >= 0; i--) {
                boolean next = gears[num][i];
                gears[num][i] = cur;
                cur = next;
            }
        }
    }

    private static void rotateRight(boolean[][] gears, int num, int dir) {
        if (num + 1 < T && gears[num][2] != gears[num + 1][6]) {
            if (dir == 1) {
                rotateRight(gears, num + 1, -1);
            } else {
                rotateRight(gears, num + 1, 1);
            }
        }
        if (dir == 1) {
            boolean cur = gears[num][0];
            gears[num][0] = gears[num][7];

            for (int i = 1; i <= 7; i++) {
                boolean next = gears[num][i];
                gears[num][i] = cur;
                cur = next;
            }
        }else {
            boolean cur = gears[num][7];
            gears[num][7] = gears[num][0];

            for (int i = 6; i >= 0; i--) {
                boolean next = gears[num][i];
                gears[num][i] = cur;
                cur = next;
            }
        }
    }
}