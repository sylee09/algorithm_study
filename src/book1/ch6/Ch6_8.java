package book1.ch6;

import java.util.ArrayList;
import java.util.Stack;

public class Ch6_8 {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int element : arr) {
            if (stack.isEmpty()) {
                stack.push(element);
            } else {
                if (stack.peek() == element) {
                    continue;
                } else {
                    stack.push(element);
                }
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int element : stack) {
            answerList.add(element);
        }

        return answerList.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static void main(String[] args) {
        Ch6_8 solution = new Ch6_8();
        solution.solution(new int[]{1, 2, 3});
    }
}
