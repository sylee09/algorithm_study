package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon13241 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int temp = A;
        if (A < B) {
            A = B;
            B = temp;
        }
        long gcd = gcd(A, B);
        long result = gcd * (A / gcd) * (B / gcd);
        System.out.println(result);
    }

    static long gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
