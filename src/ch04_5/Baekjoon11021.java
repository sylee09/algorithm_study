package ch04_5;

import java.util.Scanner;

public class Baekjoon11021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println("Case #" + (tc + 1) + ": " + (A + B));
        }
    }
}
