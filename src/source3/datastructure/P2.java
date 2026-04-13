package source3.datastructure;

import java.util.Stack;

public class P2 {
    public String solution(String s) {
        Stack<Character> charStack = new Stack<>();

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            if (ch == ')') {
                StringBuilder sb = new StringBuilder();
                String number = "";
                while (charStack.peek() != '(') {
                    sb.append(charStack.pop());
                }
                charStack.pop();
                if (charStack.isEmpty() || !Character.isDigit(charStack.peek())) {
                    number = "1";
                } else {
                    while (!charStack.isEmpty() && Character.isDigit(charStack.peek())) {
                        number = charStack.pop() + number;
                    }
                }
                StringBuilder origin = new StringBuilder(sb.reverse());

                for (int i = 1; i < Integer.parseInt(number); i++) {
                    sb = sb.append(origin);
                }

                for (char c : sb.toString().toCharArray()) {
                    charStack.push(c);
                }
            } else {
                charStack.push(ch);
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!charStack.isEmpty()) {
            answer.append(charStack.pop());
        }

        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        P2 T = new P2();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
