package source2;

import java.util.Scanner;

public class P25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] answer = new int[N + M];
        int left = 0;
        int right = 0;

        for (int idx = 0; idx < N + M; idx++) {
            if (left < N && right < M) {
                if (arr1[left] <= arr2[right]) {
                    answer[idx] = arr1[left];
                    left++;
                } else {
                    answer[idx] = arr2[right];
                    right++;
                }
            } else if (left == N) {
                answer[idx] = arr2[right++];
            } else {
                answer[idx] = arr1[left++];
            }
        }

        for (int element : answer) {
            System.out.print(element+" ");
        }
    }
}
