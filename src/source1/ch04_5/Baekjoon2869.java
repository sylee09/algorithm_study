package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        System.out.println((int) Math.ceil((double) (V - B) / (A - B)));
    }
}
