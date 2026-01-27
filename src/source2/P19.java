package source2;

import java.util.Scanner;

public class P19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        int score = 1;

        for (int idx = 0; idx < N; idx++) {
            if (arr[idx] == 1) {
                ans += score;
                score++;
            } else {
                score = 1;
            }
        }

        System.out.println(ans);
    }
}
