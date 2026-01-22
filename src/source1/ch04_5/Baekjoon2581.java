package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num = M; num <= N; num++) {
            if (isPrime(num)) {
                if (min > num) {
                    min = num;
                }
                sum += num;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
