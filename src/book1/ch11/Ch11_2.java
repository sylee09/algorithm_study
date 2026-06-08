package book1.ch11;

import java.util.*;

public class Ch11_2 {

    private static int[] solution(int[][] graph, int start, int n) {
        HashMap<Integer, ArrayList<Integer>> graphMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graphMap.put(i, new ArrayList<>());
        }

        for (int[] g : graph) {
            int from = g[0];
            int to = g[1];

            ArrayList<Integer> list = graphMap.get(from);
            list.add(to);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        deque.offer(start);
        set.add(start);

        while (!deque.isEmpty()) {
            int poll = deque.poll();
            answer.add(poll);

            for (int neighbor : graphMap.get(poll)) {
                if (!set.contains(neighbor)) {
                    deque.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return answer.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}}, 1, 9)));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 3}, {3, 4}, {3, 5}, {5, 2}}, 1, 5)));
    }
}
