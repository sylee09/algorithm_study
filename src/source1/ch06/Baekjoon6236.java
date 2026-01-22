package source1.ch06;

import java.util.Scanner;

public class Baekjoon6236 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int l = 0, r = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            r += num;
            arr[i] = num;
            if (l < num) {
                l = num;
            }
        }

        // lowerbound 탐색
        while (l < r) {
            int mid = (l + r) / 2;
            int num = 1;
            int sum = 0;

            for (int element : arr) {
                sum += element;
                if (sum > mid) {
                    num++;
                    sum = element;
                }
                if (num > M) {
                    break;
                }
            }

            if (num > M) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l);
    }
}
