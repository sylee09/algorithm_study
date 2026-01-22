package source1.ch05;

import java.util.Scanner;

public class Baekjoon1912 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 첫원소를 answer,sum에 할당.
        int answer = arr[0];
        int sum = arr[0];
        // 1부터 N-1까지 값넣고 비교
        for (int i = 1; i < N; i++) {
            sum += arr[i];
            // sum은 sum과 현재 원소중 더 큰 값
            sum = Math.max(sum, arr[i]);
            if (answer < sum) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}
