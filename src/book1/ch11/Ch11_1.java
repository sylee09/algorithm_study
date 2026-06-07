package book1.ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Ch11_1 {

    private static int[] solution(int[][] graph, int start, int n) {
        HashMap<Integer, ArrayList<Integer>> graphMap = new HashMap<>();

        for (int[] g : graph) {
            int from = g[0];
            int to = g[1];
            ArrayList<Integer> list = graphMap.getOrDefault(from, new ArrayList<Integer>());
            list.add(to);
            graphMap.put(from, list);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        dfs(graphMap, start, new HashSet<Integer>(), answer);
        return answer.stream().mapToInt(s -> s.intValue()).toArray();
    }

    static void dfs(HashMap<Integer, ArrayList<Integer>> graphMap, int start, HashSet<Integer> set, ArrayList<Integer> answer) {
        if (set.contains(start)) {
            return;
        }
        set.add(start);
        answer.add(start);
        if (graphMap.containsKey(start)) {
            for (int neighbor : graphMap.get(start)) {
                dfs(graphMap, neighbor, set, answer);
            }
        }
    }

    public static void main(String[] args) {
        Ch11_1 solution = new Ch11_1();
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 1, 5)));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}}, 1, 6)));
    }
}
