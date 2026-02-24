package source2;

import java.util.Scanner;

public class P59 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = i;
                    continue;
                }
                if (i < j) {
                    break;
                }
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][R]);
    }
}
