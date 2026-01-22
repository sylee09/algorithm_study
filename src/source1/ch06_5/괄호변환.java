package source1.ch06_5;

import java.util.Stack;

public class 괄호변환 {

    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }
        return func(p);
    }

    public String func(String p) {
        if (p.isEmpty()) {
            return p;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        int i=0;
        for (; i < p.length(); i++) {
            if (cnt1 > 0 && cnt1 == cnt2) {
                break;
            }
            if (p.charAt(i) == '(') {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        String u = p.substring(0, i);
        String v = p.substring(i);

        if (checkFunc(u)) {
            return u + func(v);
        } else {
            String ret = "(" + solution(v) + ")";
            StringBuilder sb = new StringBuilder(u);
            if (sb.length() >= 1) {
                sb.deleteCharAt(0);
            }
            if (sb.length() >= 1) {
                sb.deleteCharAt(sb.length()-1);
            }
            StringBuilder str = new StringBuilder();
            for (char ch : sb.toString().toCharArray()) {
                if (ch == '(') {
                    str.append(")");
                } else {
                    str.append("(");
                }
            }
            return ret + str.toString();
        }
    }

    public boolean checkFunc(String u) {
        Stack<Character> stack = new Stack<>();
        for (char ch : u.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
