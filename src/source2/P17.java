package source2;

import java.util.Scanner;
import java.util.Arrays;

public class P17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (!arr[i]) {
                continue;
            }
            for (int j = 2; j * i <= N; j++) {
                arr[i * j] = false;
            }
        }

        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
