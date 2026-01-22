package ch07;

import java.util.Scanner;

public class Baekjoon17070 {
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1][N+1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // dp[행][열][파이프방향]
        // 파이프방향 : 0(가로), 1(대각선), 2(세로)
        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 가로로 놓기
                if (j + 1 <= N && arr[i][j + 1] == 0) {
                    dp[i][j + 1][0] += dp[i][j][0];
                    dp[i][j + 1][0] += dp[i][j][1];
                }
                // 대각선으로 놓기
                if (i + 1 <= N && j + 1 <= N && arr[i + 1][j + 1] == 0 && arr[i + 1][j] == 0 && arr[i][j + 1] == 0) {
                    dp[i + 1][j + 1][1] += dp[i][j][0];
                    dp[i + 1][j + 1][1] += dp[i][j][2];
                    dp[i + 1][j + 1][1] += dp[i][j][1];
                }
                // 세로로 놓기
                if (i + 1 <= N && arr[i + 1][j] == 0) {
                    dp[i + 1][j][2] += dp[i][j][2];
                    dp[i + 1][j][2] += dp[i][j][1];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}
