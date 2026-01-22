package source1.ch04;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon3015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<int[]> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            // 만약 현재 스택의 top보다 지금 들어오는 값이 더 크거나 같다면
            while (!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
                int[] top = stack.pop();
                if (arr[i] == top[0]) {
                    cnt += top[1];
                }
                answer += top[1];
            }
            if (!stack.isEmpty()) {
                answer++;
            }
            stack.push(new int[]{arr[i], cnt});
        }

        System.out.println(answer);
    }
}
