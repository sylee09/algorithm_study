package ch04_5;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon10815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            set.add(num);
        }
        int M = sc.nextInt();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if (set.contains(num)) {
                ans.append(1 + " ");
            } else {
                ans.append(0 + " ");
            }
        }
        System.out.println(ans);
    }
}
