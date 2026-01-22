package source1.ch07;


import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2098 {
    static int N;
    static int[][] W;
    static int INF = 16_000_000;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받기
        N = sc.nextInt();
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        // dp[현재도시][방문한도시] = 현재도시와 방문한도시가 주어졌을때 tsp 결과
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int cur, int visit) {
        // 기저 조건
        if ((1 << N) - 1 == visit) {
            if (W[cur][0] != 0) {
                return W[cur][0];
            }
            return INF;
        }

        // 이미 dp 값이 존재할때
        if (dp[cur][visit] != -1) {
            return dp[cur][visit];
        }

        dp[cur][visit] = INF;

        // 이동
        for (int next = 0; next < N; next++) {
            if (W[cur][next] != 0 && (visit & (1 << next)) == 0) {
                int candidate = tsp(next, visit | 1 << next) + W[cur][next];
                dp[cur][visit] = Math.min(dp[cur][visit], candidate);
            }
        }

        return dp[cur][visit];
    }

}
