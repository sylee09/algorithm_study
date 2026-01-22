package source1.ch04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon13244 {
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int i = 1; i <= M; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                graph.get(A).add(B);
                graph.get(B).add(A);
            }

            if (N - 1 != M) {
                System.out.println("graph");
            } else {
                boolean[] check = new boolean[N + 1];
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                deque.offer(1);
                check[1] = true;
                while (!deque.isEmpty()) {
                    int cur = deque.poll();
                    for (int neighbor : graph.get(cur)) {
                        if (!check[neighbor]) {
                            check[neighbor] = true;
                            deque.offer(neighbor);
                        }
                    }
                }

                boolean isTree = true;
                for (int i = 1; i <= N; i++) {
                    if (!check[i]) {
                        isTree = false;
                        break;
                    }
                }

                if (isTree) {
                    System.out.println("tree");
                } else {
                    System.out.println("graph");
                }
            }
        }
    }
}
