package source1.ch04_5;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        Stack<Character> stack = new Stack<>();
        for (int tc = 1; tc <= T; tc++) {
            stack.clear();
            String line = sc.nextLine();
            boolean flag = true;
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (flag) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
