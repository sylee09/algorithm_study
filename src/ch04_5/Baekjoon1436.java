package ch04_5;

import java.util.Scanner;

public class Baekjoon1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long cur = 666L;
        int cnt = 1;

        while (true) {
            if (cnt == N) {
                System.out.println(cur);
                return;
            }
            cur++;
            if (checkFunc(cur)) {
                cnt++;
            }
        }
    }

    static boolean checkFunc(long cur) {
        String number = String.valueOf(cur);
        for (int i = 0; i <= number.length() - 3; i++) {
            boolean flag = true;
            for (int j = i; j < i + 3; j++) {
                if (number.charAt(j) != '6') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
