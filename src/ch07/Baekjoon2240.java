package ch07;

import java.util.Scanner;

public class Baekjoon2240 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int W = sc.nextInt();

        int[] trees = new int[T];
        for (int i = 0; i < T; i++) {
            trees[i] = sc.nextInt() - 1;
        }

        // dp [움직임][시간]
        int[][] dp = new int[W + 1][T + 1];

        for (int w = 0; w <= W; w++) {
            for (int t = 1; t <= T; t++) {
                int tree = trees[t - 1];
                int cur = w % 2;

                int add = tree == cur ? 1 : 0;

                if (w == 0) {
                    dp[w][t] = dp[w][t - 1] + add;
                } else {
                    dp[w][t] = Math.max(dp[w - 1][t - 1], dp[w][t - 1]) + add;
                }
            }
        }
//        for (int w = 0; w <= W; w++) {
//            for (int t = 0; t <= T; t++) {
//                System.out.print(dp[w][t]+" ");
//            }
//            System.out.println();
//        }

        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, dp[w][T]);
        }
        System.out.println(answer);
    }
}
