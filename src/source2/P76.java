package source2;

import java.util.Arrays;
import java.util.Scanner;

public class P76 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int element : arr) {
                if (element <= i) {
                    dp[i] = Math.min(dp[i - element] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[target]);
    }
}
