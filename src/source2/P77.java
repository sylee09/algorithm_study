package source2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P77 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            list.add(new int[]{score, time});
        }

        list.sort((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        int[] dp = new int[M + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int[] element : list) {
            for (int j = M; j >= element[1]; j--) {
                if (dp[j - element[1]] != -1) {
                    dp[j] = Math.max(dp[j - element[1]] + element[0], dp[j]);
                }
            }
        }

        int answer = 0;
        for (int score : dp) {
            answer = Math.max(answer, score);
        }

        System.out.println(answer);
    }
}
