package ch06;

import java.util.Scanner;

public class Baekjoon2792 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        int left = 0; // 질투도 최소
        int right = 0; // 질투도 최대
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
            if (right < arr[i]) {
                right = arr[i];
            }
        }

        // 이진탐색
        while (left < right) {
            int people = 0;
            int mid = (left + right) / 2;
            for (int element : arr) {
                people += (int) Math.ceil((double) element / mid);
            }
            if (people <= N) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
