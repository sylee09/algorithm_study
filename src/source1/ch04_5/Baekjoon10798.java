package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon10798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 15; j++) {
                if (j >= line.length()) {
                    arr[i][j] = ' ';
                } else {
                    arr[i][j] = line.charAt(j);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != ' ') {
                    answer.append(arr[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}
