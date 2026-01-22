package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2480 {

    public static void main(String[] args) {
        int[] arr = new int[7];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            arr[sc.nextInt()]++;
        }

        int answer = 0;
        int max = 0;
        boolean flag = false;

        for (int i = 1; i <= 6; i++) {
            if (arr[i] == 3) {
                answer += 10_000 + i * 1000;
                flag = true;
            } else if (arr[i] == 2) {
                answer += 1000 + i * 100;
                flag = true;
            } else if (arr[i] == 1) {
                max = Math.max(max, i);
            }
        }
        if (!flag) {
            answer += max * 100;
        }

        System.out.println(answer);
    }
}
