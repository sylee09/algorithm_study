package ch05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon2109 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 값을 오름차순 정렬
        PriorityQueue<int[]> answer = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        // 날짜를 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            int day = sc.nextInt();
            pq.offer(new int[]{value, day});
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            answer.offer(poll);
            int size = answer.size();
            // 만약 큐에 들어있는 원소의 수가 day 보다 크면 가장 작은 값을 가진 원소을 poll 해야함
            if (size > poll[1]) {
                answer.poll();
            }
        }

        int ans = 0;
        while (!answer.isEmpty()) {
            ans += answer.poll()[0];
        }

        System.out.println(ans);
    }
}
