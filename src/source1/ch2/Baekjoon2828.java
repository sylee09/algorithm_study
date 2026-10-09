package source1.ch2;

import java.util.Scanner;

public class Baekjoon2828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int J = sc.nextInt();

        int left = 1;
        int right = left + M - 1;

        int answer = 0;

        for (int j = 0; j < J; j++) {
            int x = sc.nextInt();
            if (left <= x && x <= right) {
                continue;
            }
            if (Math.abs(left - x) < Math.abs(right - x)) {
                right = right - Math.abs(left - x);
                answer += Math.abs(left - x);
                left = x;
            } else {
                left = left + Math.abs(right - x);
                answer += Math.abs(right - x);
                right = x;
            }
        }

        System.out.println(answer);
    }
}
