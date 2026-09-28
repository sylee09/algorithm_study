package source1.ch1;

import java.util.Scanner;

public class Ch1_8 {

    public static void main(String[] args) {
        // 1. 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] accumArr = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2. 슬라이딩윈도우 배열 채우기 & 최댓값 찾기
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        accumArr[0] = sum;
        int answer = sum;

        int idx = 1;
        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            accumArr[idx] = sum;
            answer = Integer.max(answer, accumArr[idx]);
            idx++;
        }

        System.out.println(answer);
    }
}
