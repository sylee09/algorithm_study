package ch07;

import java.util.Scanner;

public class Baekjoon2748 {

    public static void main(String[] args) {
        long[] dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
