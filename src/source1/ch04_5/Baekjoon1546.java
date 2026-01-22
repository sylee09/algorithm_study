package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            if (score > max) {
                max = score;
            }
            arr[i] = score;
        }

        double avg = 0;

        for (int score : arr) {
            avg += ((double) score / max * 100);
        }

        avg /= N;

        System.out.println(avg);
    }
}
