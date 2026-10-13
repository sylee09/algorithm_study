package source1.implementation;

import java.util.Scanner;

public class Baekjoon10813 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            int temp = arr[x];

            arr[x] = arr[y];
            arr[y] = temp;
        }

        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
