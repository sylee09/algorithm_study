package source1.ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon14215 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = 0;

        if (arr[2] < arr[0] + arr[1]) {
            ans = arr[0] + arr[1] + arr[2];
        } else {
            ans = (arr[0] + arr[1] - 1) + arr[0] + arr[1];
        }
        System.out.println(ans);
    }
}
