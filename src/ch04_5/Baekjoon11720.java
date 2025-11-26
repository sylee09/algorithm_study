package ch04_5;

import java.util.Scanner;

public class Baekjoon11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        System.out.println(answer);
    }
}
