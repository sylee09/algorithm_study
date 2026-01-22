package source1.ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon25305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            }
            return 0;
        });

        System.out.println(arr[k - 1]);

    }
}
