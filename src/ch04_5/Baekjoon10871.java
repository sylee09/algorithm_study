package ch04_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon10871 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num < X) {
                list.add(num);
            }
        }

        for (int element : list) {
            System.out.print(element + " ");
        }
    }
}
