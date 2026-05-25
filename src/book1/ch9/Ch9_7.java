package book1.ch9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ch9_7 {

    public int solution(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph;
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // 임의의 점 1에서 가장 먼 노드 X를 찾음 (start)
        int[] result = bfs(graph, 1, n);
        int x = 1;
        for (int i = 2; i <= n; i++) {
            if(result[i]>result[x]) x = i;
        }

        // x에서 각 노드까지의 값을 찾음
        int[] distX = bfs(graph, x, n);
        int y = 1;
        for (int i = 2; i <= n; i++) {
            if(distX[i]>distX[y]) y = i;
        }
        int diameter = distX[y];    // 지름을 명시적으로 저장

        // X에서 거리 D인 노드 개수
        int cntFromX = 0;
        for (int i = 1; i <= n; i++) {
            if (distX[i] == diameter) cntFromX++;
        }
        if (cntFromX >= 2) return diameter;

        // 3. Y에서 BFS → Y에서 거리 D인 노드 개수
        int[] distY = bfs(graph, y, n);
        int cntFromY = 0;
        for (int i = 1; i <= n; i++) {
            if (distY[i] == diameter) cntFromY++;
        }
        if (cntFromY >= 2) return diameter;

        return diameter - 1;
    }

    static int[] bfs(HashMap<Integer, ArrayList<Integer>> graph, int start, int n) {
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph.get(now)) {
                if(visit[i]) continue;
                visit[i] = true;
                queue.add(i);
                dist[i] = dist[now] + 1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Ch9_7 solution = new Ch9_7();
        System.out.println(solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
