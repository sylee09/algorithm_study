package ch05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1781 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 날짜 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        // 컵라면수 오름차순
        PriorityQueue<int[]> ansQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            int deadLine = sc.nextInt();
            int cupRamen = sc.nextInt();

            pq.offer(new int[]{deadLine, cupRamen});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            ansQueue.offer(cur);
            if (cur[0] < ansQueue.size()) {
                ansQueue.poll();
            }
        }

        int answer = 0;

        while (!ansQueue.isEmpty()) {
            int[] cur = ansQueue.poll();
            answer += cur[1];
        }

        System.out.println(answer);
    }
}
