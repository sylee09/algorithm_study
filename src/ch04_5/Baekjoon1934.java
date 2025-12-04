package ch04_5;

import java.util.Scanner;

public class Baekjoon1934 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int temp = B;
            if (A < B) {
                B = A;
                A = temp;
            }
            int result = gcd(A, B);
            System.out.println(result * (A / result) * (B / result));
        }
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A % B);
        }
    }
}
