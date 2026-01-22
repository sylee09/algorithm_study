package source1.ch06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon14003 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        ArrayList<Long> lis = new ArrayList<>();
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (lis.isEmpty()) {
                lis.add(arr[i]);
                dp[i] = 1;
            } else {
                int idx = lowerbound(arr[i], lis);
                if (idx == lis.size()) {
                    lis.add(arr[i]);
                    dp[i] = lis.size();
                } else {
                    lis.set(idx, arr[i]);
                    dp[i] = idx + 1;
                }
            }
        }
        int length = lis.size();
        int dupLength = length;
        Stack<Long> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == dupLength) {
                stack.push(arr[i]);
                dupLength--;
            }
        }


        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop() + " ");
        }

        System.out.println(length);
        System.out.println(ans);
    }

    static int lowerbound(long target, ArrayList<Long> lis) {
        int l = 0;
        int r = lis.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (lis.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
