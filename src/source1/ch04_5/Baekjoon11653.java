package source1.ch04_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11653 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> prime = new ArrayList<Integer>();
        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            int limit = N / i;
            for (int j = 2; j <= limit; j++) {
                arr[i * j] = false;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                prime.add(i);
            }
        }

        while (N > 1) {
            for (int p : prime) {
                if (N % p == 0) {
                    System.out.println(p);
                    N /= p;
                    break;
                }
            }
        }
    }
}
