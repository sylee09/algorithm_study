package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon4134 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long n = sc.nextLong();
            if (n == 0 || n == 1) {
                System.out.println(2);
                continue;
            }
            for (long num = n; ; num++) {
                if (isPrime(num)) {
                    System.out.println(num);
                    break;
                }
            }
        }
    }

    static boolean isPrime(long num) {
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
