package source1.ch06;

import java.util.Scanner;

public class Baekjoon2343 {

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int l = 0;
        int r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > l) {
                // 동영상이 잘리면 안되므로 l = 동영상중 가장 길이가 긴것.
                l = arr[i];
            }
            r += arr[i];
        }

        // lowerbound 탐색
        while (l < r) {
            int mid = (l + r) / 2;
            int num = 1;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > mid) {
                    num += 1;
                    sum = arr[i];
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
