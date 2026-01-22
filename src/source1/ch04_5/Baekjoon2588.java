package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2588 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int result = num1 * num2;
        while (num2 > 0) {
            int n = num2 % 10;
            System.out.println(num1 * n);
            num2 /= 10;
        }
        System.out.println(result);
    }
}
