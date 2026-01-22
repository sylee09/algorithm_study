package source1.ch01;

import java.util.Scanner;

public class Baekjoon2559 {

    public static void main(String[] args) {
        //입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 정답구하기 (sliding window)
        long answer = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        answer = sum;

        for (int i = K; i < arr.length; i++) {
            sum -= arr[i - K];
            sum += arr[i];

            if (answer < sum) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}
