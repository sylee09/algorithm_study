package source1.implementation;

import java.util.Scanner;

public class Baekjoon1100 {

    public static void main(String[] args) {
        boolean[][] arr = new boolean[8][8];
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            String line = sc.nextLine();
            for (int idx = 0; idx < 8; idx++) {
                if (line.charAt(idx) == 'F' && (idx+i) % 2 == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
