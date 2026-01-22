package source1.ch05;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
            // 만약 타겟의 마지막 값과 현재 push된 값이 같고 스택 크기가 타겟 길이보다 크다면
            // 타겟 길이만큼 stack pop한뒤 이것의 거꾸로 한 스트링이 타겟과 같은지 확인
            // 같다면 그대로 진행 다르다면 스택을 원상복귀 시킨다.
            if (ch == target.charAt(target.length() - 1) && stack.size() >= target.length()) {
                StringBuilder sb = new StringBuilder();
                Stack<Character> original = new Stack<>();
                for (int i = 0; i < target.length(); i++) {
                    char element = stack.pop();
                    original.push(element);
                    sb.append(element);
                }
                if (!sb.reverse().toString().equals(target)) {
                    while (!original.isEmpty()) {
                        stack.push(original.pop());
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        System.out.println(ans.reverse().toString());
    }
}
