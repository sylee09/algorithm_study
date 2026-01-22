package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon1193 {

    public static void main(String[] args) {
        boolean downFlag = false;
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int cnt = 1;
        int x = 1;
        int y = 1;

        while (true) {
            if (X == cnt) {
                System.out.println(x + "/" + y);
                break;
            }
            cnt++;
            if (!downFlag) {
                if (x == 1) {
                    y += 1;
                    downFlag = true;
                } else {
                    x -= 1;
                    y += 1;
                }
            } else {
                if (y == 1) {
                    x += 1;
                    downFlag = false;
                } else {
                    x += 1;
                    y -= 1;
                }
            }
        }
    }
}
