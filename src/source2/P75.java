package source2;

import java.util.ArrayList;
import java.util.Scanner;

public class P75 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            list.add(new int[]{area, height, weight});
        }

        list.sort((a, b) -> {
            if (a[0] > b[0]) {
                return -1;
            } else if (a[0] < b[0]) {
                return 1;
            }
            return 0;
        });

        // dp[i] : i번째 벽돌을 가장 위에 놓일 때의 최대 높이
        int[] dp = new int[N];
        int maxTotalHeight = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = list.get(i)[1];
            for (int j = 0; j < i; j++) {
                // j번째 벽돌의 무게가 i번째 벽돌의 무게보다 클때
                if (list.get(j)[2] > list.get(i)[2]) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i)[1]);
                }
            }
            maxTotalHeight = Math.max(maxTotalHeight, dp[i]);
        }

        System.out.println(maxTotalHeight);
    }
}
