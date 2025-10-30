package ch01;

import java.util.Scanner;

public class Baekjoon10988 {
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        // 투포인터
        int l = 0;
        int r = line.length() - 1;
        while (l < r) {
            if (line.charAt(l) != line.charAt(r)) {
                System.out.println(0);
                return;
            }
            l++;
            r--;
        }
        System.out.println(1);
    }
}
