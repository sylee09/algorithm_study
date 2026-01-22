package source1.ch06;

import java.util.Scanner;

public class Baekjoon2670 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        double max = 0;
        int N = sc.nextInt();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
        }

        for (int i = 0; i < N; i++) {
            double num = arr[i];
            if (max < num) {
                max = num;
            }
            for (int j = i + 1; j < N; j++) {
                num *= arr[j];
                if (max < num) {
                    max = num;
                }
            }
        }

        System.out.printf("%.3f", max);
    }
}
