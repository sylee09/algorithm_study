package ch06;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon7795 {

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arr = new int[N];
            int[] brr = new int[M];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                brr[i] = sc.nextInt();
            }

            // arr, brr 정렬
            Arrays.sort(arr);
            Arrays.sort(brr);

            // lowerbound로 답 찾기
            int sum = 0;
            for (int target : arr) {
                sum += lowerbound(brr, target);
            }

            System.out.println(sum);
        }
    }

    static int lowerbound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
