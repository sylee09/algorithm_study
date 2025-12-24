package ch06;

import java.util.Scanner;

public class Baekjoon1072 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = (y * 100) / x;

        long l = 1;
        long r = Integer.MAX_VALUE;

        while (l < r) {
            long mid = (l + r) / 2;

            long nz = (100 * (mid + y)) / (x + mid);
            if (z == nz) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l = l == Integer.MAX_VALUE ? -1 : l;
        System.out.println(l);
    }
}
