package ch04_5;

import java.math.BigDecimal;
import java.util.Scanner;

public class Baekjoon2720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] m = new int[]{25, 10, 5, 1};
        int[] answer = new int[4];

        for (int tc = 0; tc < T; tc++) {
            int C = sc.nextInt();
            for (int i = 0; i < 4; i++) {
                answer[i] = C / m[i];
                C %= m[i];
            }
            for (int element : answer) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
