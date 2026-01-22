package source1.ch06;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon11053 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> lis = new ArrayList<>();
        int[] dp = new int[N];
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = 0;
        for (int element : arr) {
            int lowerbound = lowerbound(lis, element);
            if (lowerbound == lis.size()) {
                lis.add(element);
                dp[idx] = lis.size();
            } else {
                lis.set(lowerbound, element);
                dp[idx] = lowerbound + 1;
            }
            idx++;
        }

        System.out.println(lis.size());
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
