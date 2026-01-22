package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon24267 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        System.out.println(N * (N - 1) * (N - 2) / 6);
        System.out.println(3);
    }
}
