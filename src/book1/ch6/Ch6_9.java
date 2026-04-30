package book1.ch6;

import java.util.Stack;

public class Ch6_9 {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();

        String[] split = s.split(" ");

        for (String str : split) {
            if (str.equals("Z")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        int answer = 0;

        while (!stack.isEmpty()) {
            String pop = stack.pop();
            answer += Integer.parseInt(pop);
        }

        return answer;
    }
}
