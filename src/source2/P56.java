package source2;

import java.util.Scanner;

public class P56 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(arr, 0, 0, C);

        System.out.println(answer);
    }

    static void dfs(int[] arr, int idx, int sum, int limit) {
        if (sum > limit) {
            return;
        }

        if (sum > answer) {
            answer = sum;
        }

        for (int i = idx; i < arr.length; i++) {
            sum += arr[i];
            dfs(arr, i + 1, sum, limit);
            sum -= arr[i];
        }
    }
}
