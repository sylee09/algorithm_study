package book1;

import java.util.Arrays;
import java.util.Stack;

public class Ch6_5 {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty() || stack.peek()[1] <= prices[i]) {
                stack.push(new int[]{i, prices[i]});
            } else if (stack.peek()[1] > prices[i]) {
                while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                    int[] pop = stack.pop();
                    int idx = pop[0];
                    answer[idx] = i - idx;
                }
                stack.push(new int[]{i, prices[i]});
            }
        }

        if (!stack.isEmpty()) {
            int topIdx = stack.pop()[0];
            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                int idx = pop[0];
                answer[idx] = topIdx - idx;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch6_5 solution = new Ch6_5();
        int[] answer = solution.solution(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(answer));
    }
}
