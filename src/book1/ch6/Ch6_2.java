package book1.ch6;

import java.util.Stack;

public class Ch6_2 {
    String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Ch6_2 solution = new Ch6_2();
        System.out.println(solution.solution(10));
        System.out.println(solution.solution(27));
        System.out.println(solution.solution(12345));
    }
}
