package source2;

import java.util.Scanner;
import java.util.Stack;

public class P40 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int idx = 0; idx < line.length(); idx++) {
            if (line.charAt(idx) == '(') {
                stack.push(idx);
            } else {
                if (stack.peek() + 1 == idx) {
                    stack.pop();
                    answer += stack.size();
                } else {
                    answer += 1;
                    stack.pop();
                }
            }
        }

        System.out.println(answer);

    }
}
