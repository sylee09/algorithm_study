package source1.ch05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1202 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // weight 오름차순, value 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            pq.offer(new int[]{w, v});
        }

        // 가방 weight 오름차순 정렬
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            bags.offer(sc.nextInt());
        }

        PriorityQueue<Integer> answerQueue = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            }
            return 0;
        });

        long answer = 0;
        // 가방 무게 보다 작거나 같은것 answerQueue에 offer
        while (!bags.isEmpty()) {
            int bag = bags.poll();
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (cur[0] <= bag) {
                    answerQueue.offer(cur[1]);
                } else {
                    pq.offer(cur);
                    break;
                }
            }
            if (!answerQueue.isEmpty()) {
                answer += answerQueue.poll();
            }
        }
        System.out.println(answer);
    }
}
