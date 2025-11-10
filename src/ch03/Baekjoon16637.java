package ch03;

import java.util.Scanner;

public class Baekjoon16637 {
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        int first = Integer.parseInt(String.valueOf(line.charAt(0)));
        func(line, N, 1, first);
        System.out.println(answer);
    }

    static void func(String line, int limit, int idx, int num) {
        if (limit <= idx) {
            answer = Math.max(answer, num);
            return;
        }
        // 괄호 없음
        char op = line.charAt(idx);
        int n2 = Integer.parseInt(String.valueOf(line.charAt(idx + 1)));
        int result = calculate(num, op, n2);
        func(line, limit, idx + 2, result);

        // 괄호 있음
        if (idx + 3 < limit) {
            int n1 = Integer.parseInt(String.valueOf(line.charAt(idx + 1)));
            n2 = Integer.parseInt(String.valueOf(line.charAt(idx + 3)));
            char op1 = line.charAt(idx + 2);
            int result1 = calculate(n1, op1, n2);
            result = calculate(num, op, result1);
            func(line, limit, idx + 4, result);
        }
    }

    static int calculate(int num1, char op, int num2) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
