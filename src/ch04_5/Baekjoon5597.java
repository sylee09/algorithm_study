package ch04_5;

import java.util.Scanner;

public class Baekjoon5597 {

    public static void main(String[] args) {
        boolean[] check = new boolean[31];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 28; i++) {
            int n = sc.nextInt();
            check[n] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
