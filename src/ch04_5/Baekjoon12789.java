package ch04_5;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon12789 {

    public static void main(String[] args) {
        int cur = 1;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;

        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            if (num == cur) {
                cur++;
                while (!stack.isEmpty() && cur == stack.peek()) {
                    stack.pop();
                    cur++;
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(num);
                } else {
                    if (stack.peek() < num) {
                        flag = false;
                        break;
                    } else {
                        stack.push(num);
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("Sad");
        } else {
            while (!stack.isEmpty()) {
                if (cur != stack.pop()) {
                    flag = false;
                    break;
                } else {
                    cur++;
                }
            }
            if (flag) {
                System.out.println("Nice");
            } else {
                System.out.println("Sad");
            }
        }
    }
}
