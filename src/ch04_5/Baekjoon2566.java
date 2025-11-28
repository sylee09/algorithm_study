package ch04_5;

import java.util.Scanner;

public class Baekjoon2566 {

    public static void main(String[] args) {
        int[] position = new int[2];
        int[][] arr = new int[9][9];
        Scanner sc = new Scanner(System.in);
        int max = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    position[0] = i+1;
                    position[1] = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(position[0] + " " + position[1]);
    }
}
