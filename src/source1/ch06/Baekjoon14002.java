package source1.ch06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon14002 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        ArrayList<Integer> lis = new ArrayList<>();
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int idx = lowerbound(lis, arr[i]);
            if (idx == lis.size()) {
                lis.add(arr[i]);
                dp[i] = lis.size();
            } else {
                lis.set(idx, arr[i]);
                dp[i] = idx + 1;
            }
        }

        System.out.println(lis.size());

        Stack<Integer> stack = new Stack<>();
        int length = lis.size();

        for (int i = N - 1; i >= 0; i--) {
            if (length == dp[i]) {
                stack.push(arr[i]);
                length--;
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pop() + " ");
        }

        System.out.println(answer);
    }

    static int lowerbound(ArrayList<Integer> lis, int target) {
        int l = 0;
        int r = lis.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (lis.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
