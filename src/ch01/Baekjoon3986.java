package ch01;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon3986 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        // 스택에 알파벳 집어넣고 만약 top이 입력과 같다면 pop 아니면 push
        // 만약 스택의 크기가 0 이면 cnt++
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for (char ch : line.toCharArray()) {
                if (!stack.isEmpty()) {
                    Character top = stack.peek();
                    if (top == ch) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
