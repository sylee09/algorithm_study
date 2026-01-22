package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2444 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = N; j >= 1; j--) {
                if (j > i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 2 * N - 1; i >= N + 1; i--) {
            for (int j = N; j >= 1; j--) {
                if (j > i - N) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            for (int j = 1; j <= i - N - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
