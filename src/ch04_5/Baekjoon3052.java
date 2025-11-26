package ch04_5;

import java.util.Scanner;

public class Baekjoon3052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[43];
        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();
            int idx = n % 42;
            arr[idx]++;
        }

        int answer = 0;
        for (int i = 0; i <= 42; i++) {
            if (arr[i] > 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
