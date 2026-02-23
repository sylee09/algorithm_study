package source2;

import java.util.Arrays;
import java.util.Scanner;

public class P58 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int money = sc.nextInt();

        int[] dp = new int[501];

        Arrays.fill(dp, 1000);
        dp[0] = 0;

        for (int coin : arr) {
            for (int i = coin; i <= money; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.println(dp[money]);
    }
}
