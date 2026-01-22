package source1.ch03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon12851 {
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 각 좌표별 최단 거리 저장
        // 각 좌표별 최단 거리 경로 개수 저장
        int[] dist = new int[200_001];
        int[] ways = new int[200_001];

        Arrays.fill(dist, -1);
        Arrays.fill(ways, 1);

        // bfs로 dist, ways 배열 채우기
        ArrayDeque<int[]> deque = new ArrayDeque<int[]>();
        deque.offer(new int[]{N, 0});
        dist[N] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curX = cur[0];
            int curD = cur[1];

            int[] next = new int[]{curX + 1, curX - 1, curX * 2};

            for (int n : next) {
                if (n < 0 || n > 200_000) {
                    continue;
                }
                // 만일 처음 방문했다면
                if (dist[n] == -1) {
                    dist[n] = curD + 1;
                    ways[n] = ways[curX];
                    deque.offer(new int[]{n, curD + 1});
                }
                // 만일 최단경로로 재방문 했다면
                else if (dist[n] == curD + 1) {
                    ways[n] += ways[curX];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}
