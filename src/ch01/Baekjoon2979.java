package ch01;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon2979 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int maxEnd = 0;
        int minStart = Integer.MAX_VALUE;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new int[]{start, end});
            if (maxEnd < end) {
                maxEnd = end;
            }
            if (minStart > start) {
                minStart = start;
            }
        }

        int ans = 0;
        for (int t = minStart; t <= maxEnd; t++) {
            int cnt = 0;
            for (int[] arr : list) {
                if (arr[0] < t && arr[1] >= t) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                ans += A;
            } else if (cnt == 2) {
                ans += (2 * B);
            } else if (cnt == 3) {
                ans += (3 * C);
            }
        }
        System.out.println(ans);
    }
}
