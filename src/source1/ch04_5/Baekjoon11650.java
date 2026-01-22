package source1.ch04_5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon11650 {

    public static void main(String[] args) {
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
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pq.offer(new int[]{x, y});
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            System.out.println(poll[0] + " " + poll[1]);
        }
    }
}
