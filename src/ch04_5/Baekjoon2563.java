package ch04_5;

import java.util.Scanner;

public class Baekjoon2563 {

    public static void main(String[] args) {
        boolean[][] area = new boolean[101][101];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int b = y; b < y + 10; b++) {
                for (int a = x; a < x + 10; a++) {
                    area[b][a] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (area[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
