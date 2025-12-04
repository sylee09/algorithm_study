package ch04_5;

import java.util.Scanner;

public class Baekjoon13909 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 약수가 홀수개 일때만 불이 켜져 있는다. (제곱수 일때만 가능)
        int answer = 0;
        for (int i = 1; i * i <= N; i++) {
            answer++;
        }
        System.out.println(answer);
    }
}
