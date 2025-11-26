package ch04_5;

import java.util.Scanner;

public class Baekjoon10811 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
