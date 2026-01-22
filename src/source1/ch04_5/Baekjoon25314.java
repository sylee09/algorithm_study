package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon25314 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int limit = N / 4;
        for (int i = 0; i < limit; i++) {
            sb.append("long ");
        }

        sb.append("int");

        System.out.println(sb);
    }
}
