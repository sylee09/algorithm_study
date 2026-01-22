package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if (M >= 45) {
            M -= 45;
        } else {
            H -= 1;
            M = M + 15;
        }

        if (H < 0) {
            H += 24;
        }

        System.out.println(H + " " + M);
    }
}
