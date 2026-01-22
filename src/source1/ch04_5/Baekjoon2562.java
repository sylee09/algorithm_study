package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2562 {

    public static void main(String[] args) {
        int maxNum = 0;
        int maxIndex = -1;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 9; i++) {
            int num = sc.nextInt();
            if (num > maxNum) {
                maxNum = num;
                maxIndex = i;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxIndex);
    }
}
