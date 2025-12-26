package ch06;

import java.util.Scanner;

public class Baekjoon2670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        double answer = 0;

        for (int i = 0; i < n; i++) {
            double num = arr[i];
            answer = Math.max(num, answer);
            for (int j = i + 1; j < n; j++) {
                num *= arr[j];
                answer = Math.max(num, answer);
            }
        }

        System.out.printf("%.3f",answer);
    }
}
