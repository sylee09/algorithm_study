package source1.ch02;

import java.util.Scanner;

public class Baekjoon1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long num = 666L;

        if (N == 1) {
            System.out.println(num);
            return;
        }

        int cnt = 1;
        while (true) {
            num++;
            // 숫자가 666을 포함하지 않으면 숫자를 증가시킴
            if (!check(num)) {
                continue;
            }
            // 숫자가 666을 포함하면 cnt를 1 증가시킴
            cnt++;
            // 만약 cnt가 N과 같으면 원하는 숫자를 찾음
            if (cnt == N) {
                break;
            }

        }
        System.out.println(num);
    }

    // 숫자가 6을 3개이상 포함하는지 확인
    static boolean check(long newNum) {
        String num = String.valueOf(newNum);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (num.charAt(i) == '6') {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        for (int i = 3; i < num.length(); i++) {
            if (num.charAt(i - 3) == '6') {
                count--;
            }
            if (num.charAt(i) == '6') {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
