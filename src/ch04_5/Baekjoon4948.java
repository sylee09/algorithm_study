package ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon4948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            boolean[] arr = new boolean[2 * n + 1];
            Arrays.fill(arr, true);
            arr[0] = false;
            arr[1] = false;

            for (int i = 2; i * i <= 2 * n; i++) {
                if (!arr[i]) {
                    continue;
                }
                for (int j = i * i; j <= 2 * n; j += i) {
                    arr[j] = false;
                }
            }

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (arr[i]) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
