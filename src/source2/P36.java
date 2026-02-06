package source2;

import java.util.Scanner;
import java.util.Stack;

public class P36 {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        for (char ch : line.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        String answer = stack.isEmpty() ? "YES" : "NO";

        System.out.println(answer);
    }
}
