package ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!arr[i]) {
                continue;
            }
            for (int j = i * i; j <= N; j += i) {
                arr[j] = false;
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}
