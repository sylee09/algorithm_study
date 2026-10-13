package source1.ch2;

import java.util.Scanner;

public class Baekjoon3474 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            long N = sc.nextLong();
            long answer = 0L;

            while (N > 0) {
                answer += N / 5;
                N /= 5;
            }

            System.out.println(answer);
        }
    }

}
