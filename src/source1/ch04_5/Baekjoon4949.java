package source1.ch04_5;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon4949 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            if (line.equals(".")) {
                break;
            }
            boolean flag = true;
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("no");
                        flag = false;
                        break;
                    } else if (stack.peek() != '(') {
                        System.out.println("no");
                        flag = false;
                        break;
                    }
                    stack.pop();
                } else if (ch == ']') {
                    if (stack.isEmpty()) {
                        System.out.println("no");
                        flag = false;
                        break;
                    } else if (stack.peek() != '[') {
                        System.out.println("no");
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (flag) {
                if (stack.isEmpty()) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
