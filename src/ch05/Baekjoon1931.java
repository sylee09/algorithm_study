package ch05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.offer(new int[]{start, end});
        }

        int curTime = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // 현재 시간이 회의 시작 시간보다 작다면
            // 현재 시간은 회의 끝나는 시간
            if (curTime <= cur[0]) {
                curTime = cur[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
