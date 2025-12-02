package ch04_5;

import java.util.Scanner;

public class Baekjoon1085 {

    public static void main(String[] args) {
        int startX = 0, startY = 0;
        int endX, endY;
        int x, y;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        endX = sc.nextInt();
        endY = sc.nextInt();

        int distX = Math.min(Math.abs(x - startX), Math.abs(x - endX));
        int distY = Math.min(Math.abs(y - startY), Math.abs(y - endY));

        System.out.println(Math.min(distX, distY));
    }
}
