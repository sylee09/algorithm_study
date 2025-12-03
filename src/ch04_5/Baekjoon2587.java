package ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2587 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        int avg = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            avg += arr[i];
        }
        avg /= 5;

        Arrays.sort(arr);

        System.out.println(avg);
        System.out.println(arr[2]);
    }
}
