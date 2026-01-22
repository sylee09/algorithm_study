package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int element : arr) {
            if (isPrime(element)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isPrime(int element) {
        if (element == 1) {
            return false;
        }
        for (int i = 2; i * i <= element; i++) {
            if (element % i == 0) {
                return false;
            }
        }
        return true;
    }
}
