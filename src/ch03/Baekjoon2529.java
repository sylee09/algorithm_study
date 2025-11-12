package ch03;

import java.util.Scanner;

public class Baekjoon2529 {
    static long maxAnswer = Long.MIN_VALUE;
    static long minAnswer = Long.MAX_VALUE;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        line = line.replace(" ", "");
        sc.close();

        // 백트래킹
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[10];
        func(sb, -1, line, check);
        long comp = (long) Math.pow(10, k);

        if (maxAnswer < comp) {
            System.out.println("0" + maxAnswer);
        } else {
            System.out.println(maxAnswer);
        }
        if (minAnswer < comp) {
            System.out.println("0" + minAnswer);
        } else {
            System.out.println(minAnswer);
        }
    }

    static void func(StringBuilder sb, int idx, String line, boolean[] check) {
        if (idx == line.length()) {
            maxAnswer = Math.max(maxAnswer, Long.parseLong(sb.toString()));
            minAnswer = Math.min(minAnswer, Long.parseLong(sb.toString()));
            return;
        }

        if (sb.length() == 0) {
            for (int i = 0; i <= 9; i++) {
                sb.append(i);
                check[i] = true;
                func(sb, idx + 1, line, check);
                sb.deleteCharAt(sb.length() - 1);
                check[i] = false;
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (check[i]) {
                    continue;
                }
                check[i] = true;
                int front = Integer.parseInt(String.valueOf(sb.charAt(sb.length() - 1)));
                int rear = i;
                char op = line.charAt(idx);
                if (op == '<') {
                    if (front < rear) {
                        sb.append(rear);
                        func(sb, idx + 1, line, check);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    if (front > rear) {
                        sb.append(rear);
                        func(sb, idx + 1, line, check);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                check[i] = false;
            }
        }
    }
}
