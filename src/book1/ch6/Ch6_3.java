package book1.ch6;

import java.util.ArrayDeque;
import java.util.Stack;

public class Ch6_3 {

    public int solution(String s) {
        int n = s.length();
        int cnt = 0;

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            deque.offer(ch);
        }

        for (int i = 0; i < n; i++) {
            if (isCorrect(deque)) {
                cnt++;
            }
            deque.offer(deque.poll());
        }
        return cnt;
    }

    public boolean isCorrect(ArrayDeque<Character> deque) {
        Stack<Character> stack = new Stack<>();
        for (char ch : deque) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ']') {
                if (stack.isEmpty()||stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if (ch == ')') {
                if (stack.isEmpty()||stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            if (ch == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Ch6_3 solution = new Ch6_3();
        System.out.println(solution.solution("}]()[{"));
    }
}
