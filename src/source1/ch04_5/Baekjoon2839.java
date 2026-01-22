package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 5로 나누어 지면 몫이 최대값
        if (N % 5 == 0) {
            System.out.println(N / 5);
            return;
        }
        // 5로 나눌때 몫이 limit
        int limit = N / 5;
        for (int i = limit; i >= 0; i--) {
            int s = N - i * 5;
            if (s % 3 == 0) {
                System.out.println(i + (s / 3));
                return;
            }
        }
        System.out.println(-1);
    }
}
