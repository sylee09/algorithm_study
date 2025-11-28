package ch04_5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon11005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Character> map = new HashMap<>();
        char ch = 'A';
        for (int i = 10; i <= 35; i++) {
            map.put(i, (char) ch);
            ch++;
        }

        String line = sc.nextLine();
        String[] split = line.split(" ");
        int num = Integer.parseInt(split[0]);
        int digit = Integer.parseInt(split[1]);
        Stack<Character> stack = new Stack<>();

        while (num > 0) {
            int n = num % digit;
            if (n >= 10) {
                stack.push(map.get(n));
            } else {
                stack.push(String.valueOf(n).charAt(0));
            }
            num /= digit;
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }
}
