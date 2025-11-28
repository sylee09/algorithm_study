package ch04_5;

import java.util.Scanner;

public class Baekjoon9506 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            boolean[] nums = new boolean[n + 1];
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    nums[i] = true;
                }
            }
            if (sum == n) {
                sb.append(n + " = ");
                for (int i = 1; i < n; i++) {
                    if (n % i == 0) {
                        sb.append(i + " + ");
                    }
                }
                sb.delete(sb.length() - 2, sb.length());
            } else {
                sb.append(n + " is NOT perfect.");
            }
            System.out.println(sb);
        }
    }
}
