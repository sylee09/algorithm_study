package ch03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon13913 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dist = new int[200_001];
        int[] parent = new int[200_001];

        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);

        // bfs로 dist, parent 채움
        dist[N] = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(N);
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int cur = deque.poll();
                if (cur == K) {
                    break;
                }
                int[] next = new int[]{cur + 1, cur - 1, cur * 2};
                for (int n : next) {
                    if (n < 0 || n > 200_000) {
                        continue;
                    }
                    if (dist[n] == -1) {
                        dist[n] = level;
                        parent[n] = cur;
                        deque.offer(n);
                    }
                }
            }
            level++;
        }
        System.out.println(dist[K]);
        printRoute(parent, K);
    }

    static void printRoute(int[] parent, int cur) {
        if (cur == -1) {
            return;
        }
        printRoute(parent, parent[cur]);
        System.out.print(cur+" ");
    }
}
