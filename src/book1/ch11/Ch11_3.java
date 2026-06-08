package book1.ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Ch11_3 {

    public static int[] solution(int[][] graph, int start, int n) {
        HashMap<Integer, ArrayList<int[]>> graphMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graphMap.put(i, new ArrayList<>());
        }

        for (int[] g : graph) {
            int from = g[0];
            int to = g[1];
            int weight = g[2];

            ArrayList<int[]> list = graphMap.get(from);
            list.add(new int[]{to, weight});
        }

        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int weight = poll[1];
            if (answer[cur] < weight) {
                continue;
            }

            for (int[] neighbor : graphMap.get(cur)) {
                int newWeight = neighbor[1] + weight;
                if (newWeight < answer[neighbor[0]]) {
                    pq.offer(new int[]{neighbor[0], newWeight});
                    answer[neighbor[0]] = newWeight;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}}, 0, 3)));
        System.out.println(Arrays.toString(solution(new int[][]{{0, 1, 1}, {1, 2, 5}, {2, 3, 1}}, 0, 4)));
    }
}
