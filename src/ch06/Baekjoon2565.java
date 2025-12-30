package ch06;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon2565 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pq.offer(new int[]{x, y});
        }

        // lis 길이 구하기
        ArrayList<Integer> lis = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int lowerbound = lowerbound(lis, cur[1]);
            if (lowerbound == lis.size()) {
                lis.add(cur[1]);
            } else {
                lis.set(lowerbound, cur[1]);
            }
        }
        int length = lis.size();

        System.out.println(N - length);
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
