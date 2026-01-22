package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon24313 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        int first;
        int second;

        for (int n = n0; n <= 100; n++) {
            first = a1 * n + a2;
            second = c * n;

            if (first > second) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
