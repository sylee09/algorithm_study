package source2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P67 {

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

        int answer = 0;
        int end = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int s = cur[0];
            int e = cur[1];

            if (end <= s) {
                answer++;
                end = e;
            }
        }

        System.out.println(answer);
    }
}
