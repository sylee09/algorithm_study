package ch04_5;

import java.util.Scanner;

public class Baekjoon2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int gap = sc.nextInt();
        M += gap;

        if (M / 60 > 0) {
            H += (M / 60);
            M %= 60;
            if (H >= 24) {
                H -= 24;
            }
        }

        System.out.println(H + " " + M);
    }
}
