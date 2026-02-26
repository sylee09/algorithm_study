package source2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P66 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return 1;
            } else if (a[0] > b[0]) {
                return -1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            pq.offer(new int[]{h, w});
        }

        int answer = 0;
        int maxWeight = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (maxWeight < cur[1]) {
                answer++;
                maxWeight = cur[1];
            }
        }

        System.out.println(answer);

    }
}
