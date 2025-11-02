package ch01;

import java.util.Scanner;

public class Baekjoon4375 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int len = 1;
            int num2 = 1;

            while (num2 % num != 0) {
                num2 = (num2 * 10 + 1) % num;
                len++;
            }
            System.out.println(len);
        }
    }
}
