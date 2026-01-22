package source1.ch04;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon15926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        int[] arr = new int[n + 1];
        Stack<Integer> stack = new Stack<>();

        // arr[i] = 1 이면 ()을 이루는 인덱스의 값이 1
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    arr[i] = 1;
                    arr[i] = arr[stack.pop()] = 1;
                }
            }
        }

        int answer = 0;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                candidate++;
                answer = Math.max(candidate, answer);
            } else {
                candidate = 0;
            }
        }

        System.out.println(answer);


    }
}
