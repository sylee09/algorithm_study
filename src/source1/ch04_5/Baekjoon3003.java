package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon3003 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 8};
        int[] input = new int[6];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            input[i] = sc.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(arr[i]-input[i]+" ");
        }
    }
}
