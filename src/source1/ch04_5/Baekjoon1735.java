package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon1735 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A1 = sc.nextInt();
        int B1 = sc.nextInt();
        int A2 = sc.nextInt();
        int B2 = sc.nextInt();

        int gcd = gcd(B1, B2);
        int lcm = gcd * (B1 / gcd) * (B2 / gcd);

        int a = A1 * (lcm / B1) + A2 * (lcm / B2);
        int b = lcm;

        gcd = gcd(a, b);
        a = a / gcd;
        b = b / gcd;

        System.out.println(a + " " + b);
    }

    static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
