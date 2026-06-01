package book1.ch10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Ch10_4 {
    public int solution(int n, int[][] costs) {
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] cost : costs) {
            int n1 = cost[0];
            int n2 = cost[1];
            int w = cost[2];
            ArrayList<int[]> list = graph.get(n1);
            list.add(new int[]{n2, w});
            ArrayList<int[]> list1 = graph.get(n2);
            list1.add(new int[]{n1, w});
        }

        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        set.add(0);

        ArrayList<int[]> list = graph.get(0);
        for (int[] l : list) {
            pq.offer(l);
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int next = poll[0];
            if (set.contains(next)) {
                continue;
            }
            answer += poll[1];
            set.add(next);

            for (int[] neighbor : graph.get(next)) {
                if (set.contains(neighbor[0])) {
                    continue;
                }
                pq.offer(neighbor);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch10_4 solution = new Ch10_4();
        System.out.println(solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}
