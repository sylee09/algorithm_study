package book1.ch9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class Ch9_4 {
    static class Info {
        private int node, sheep, wolf;
        private HashSet<Integer> visited;

        public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    static ArrayList<Integer>[] trees;

    static void buildTree(int[] info, int[][] edges) {
        trees = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            trees[e[0]].add(e[1]);
        }
    }

    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges);

        ArrayDeque<Info> deque = new ArrayDeque<>();
        deque.offer(new Info(0, 1, 0, new HashSet<>()));

        int answer = 0;
        while (!deque.isEmpty()) {
            Info cur = deque.poll();
            answer = Math.max(answer, cur.sheep);
            cur.visited.addAll(trees[cur.node]);

            for (int next : cur.visited) {
                HashSet<Integer> set = new HashSet<>(cur.visited);
                set.remove(next);
                if (info[next] == 1) {
                    if (cur.sheep != cur.wolf + 1) {
                        deque.offer(new Info(next, cur.sheep, cur.wolf + 1, set));
                    }
                } else {
                    deque.offer(new Info(next, cur.sheep + 1, cur.wolf, set));
                }
            }
        }
        return answer;
    }
}
