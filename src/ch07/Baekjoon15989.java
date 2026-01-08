package ch07;

import java.util.Scanner;

public class Baekjoon15989 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dp = new int[10001];
        dp[0] = 1;
        for (int x = 1; x <= 3; x++) {
            for (int i = 1; i <= 10000; i++) {
                // 1칸씩 이동 : dp[i-1]의 개수와 같다.
                // 2칸씩 이동 : dp[i-2]의 개수와 같다.
                // 3칸씩 이동 : dp[i-3]의 개수와 같다.
                if(x<=i) dp[i] += dp[i - x];
            }
        }

        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
