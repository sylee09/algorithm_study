package source2;

import java.util.Scanner;

public class P55 {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        dfs(0, arr, sum, 0);

        String answer = found == true ? "YES" : "NO";

        System.out.println(answer);
    }

    static void dfs(int idx, int[] arr, int sum, int subSum) {
        if (found) {
            return;
        }
        if (sum - subSum == subSum) {
            found = true;
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            subSum += arr[i];
            dfs(i + 1, arr, sum, subSum);
            subSum -= arr[i];
        }
    }
}
