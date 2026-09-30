package source1.ch1;

import java.util.Scanner;
import java.util.Stack;

public class Ch1_13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for (char ch : line.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
