package source2;

import java.util.Scanner;
import java.util.Stack;

public class P39 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Stack<String> stack = new Stack<>();

        for (char ch : line.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch(ch) {
                    case '+':
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case '-':
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case '*':
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case '/':
                        stack.push(String.valueOf(num1 / num2));
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(stack.pop());
    }
}
