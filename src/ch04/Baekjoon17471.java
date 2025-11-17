package ch04;

import java.util.*;

public class Baekjoon17471 {
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] population = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            population[i] = sc.nextInt();
        }

        // 그래프 그리기
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            for (int k = 0; k < n; k++) {
                int num = sc.nextInt();
                graph.get(i).add(num);
                graph.get(num).add(i);
            }
        }

        // 완전탐색
        func(graph, population, 1, new ArrayList<Integer>());
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void func(HashMap<Integer, ArrayList<Integer>> graph, int[] population, int level, ArrayList<Integer> group1) {
        // 종료 조건
        if (level == N) {
            // 만약 모두 한그룹에 모여있으면 안됨
            if (group1.size() == N || group1.size() == 0) {
                return;
            }
            // group1의 원소가 모두 연결되어 있는지 확인 bfs로
            HashSet<Integer> set1 = new HashSet<>();
            set1.addAll(group1);
            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                if (!set1.contains(i)) {
                    set2.add(i);
                }
            }
            ArrayList<Integer> group2 = new ArrayList<>();
            group2.addAll(set2);

            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
            boolean[] check = new boolean[N + 1];
            deque.offer(group1.get(0));
            set1.remove(group1.get(0));
            check[group1.get(0)] = true;

            while (!deque.isEmpty()) {
                int cur = deque.poll();

                for (int neighbor : graph.get(cur)) {
                    // 중복방지 & 그룹2에 속한것은 지나면 안됨
                    if (!check[neighbor] && !set2.contains(neighbor)) {
                        check[neighbor] = true;
                        deque.offer(neighbor);
                        set1.remove(neighbor);
                    }
                }
            }
            if (!set1.isEmpty()) {
                return;
            }
            set1.addAll(group1);

            // group2의 원소가 모두 연결되어있는지 확인
            check = new boolean[N + 1];
            deque.offer(group2.get(0));
            set2.remove(group2.get(0));
            check[group2.get(0)] = true;

            while (!deque.isEmpty()) {
                int cur = deque.poll();

                for (int neighbor : graph.get(cur)) {
                    // 중복방지 & 그룹1에 속한것은 지나면 안됨
                    if (!check[neighbor] && !set1.contains(neighbor)) {
                        check[neighbor] = true;
                        deque.offer(neighbor);
                        set2.remove(neighbor);
                    }
                }
            }

            if (!set2.isEmpty()) {
                return;
            }

            int sum1 = 0;
            int sum2 = 0;

            for (int element : group1) {
                sum1 += population[element];
            }

            for (int element : group2) {
                sum2 += population[element];
            }

            int diff = Math.abs(sum1 - sum2);

            answer = Math.min(diff, answer);

            return;
        }

        group1.add(level);
        // 그룹1에 포함
        func(graph, population, level + 1, group1);
        group1.remove(group1.size() - 1);
        // 그룹1에 포함하지 않음
        func(graph, population, level + 1, group1);
    }
}
