package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2776 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            String numbers = br.readLine();
            String[] split = numbers.split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            int M = Integer.parseInt(br.readLine());
            numbers = br.readLine();
            split = numbers.split(" ");
            int[] brr = new int[M];
            for (int i = 0; i < M; i++) {
                brr[i] = Integer.parseInt(split[i]);
            }

            Arrays.sort(arr);
            StringBuilder answer = new StringBuilder();

            for (int element : brr) {
                if (binarySearch(element, arr)) {
                    answer.append("1\n");
                } else {
                    answer.append("0\n");
                }
            }

            System.out.print(answer);
        }
    }

    static boolean binarySearch(int element, int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (element == arr[mid]) {
                return true;
            }
            if (arr[mid] > element) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
