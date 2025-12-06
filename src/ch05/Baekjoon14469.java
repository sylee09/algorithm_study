package ch05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon14469 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });
        for (int i = 0; i < N; i++) {
            int enter = sc.nextInt();
            int duration = sc.nextInt();
            pq.offer(new int[]{enter, duration});
        }

        int endTime = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (endTime < poll[0]) {
                endTime = poll[0] + poll[1];
            } else {
                endTime += poll[1];
            }
        }

        System.out.println(endTime);

    }
}
