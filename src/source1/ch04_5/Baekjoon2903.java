package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2903 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lengths = new int[n + 1];
        lengths[0] = 2;
        for (int i = 1; i <= n; i++) {
            lengths[i] = lengths[i - 1] + (int) Math.pow(2, i - 1);
        }
        System.out.println(lengths[n] * lengths[n]);
    }
}
