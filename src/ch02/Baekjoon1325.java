package ch02;

import java.io.*;
import java.util.*;

public class Baekjoon1325 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        // 그래프 그리기
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            line = br.readLine();
            split = line.split(" ");
            int n2 = Integer.parseInt(split[0]);
            int n1 = Integer.parseInt(split[1]);
            graph.get(n1).add(n2);
        }

        // 답 구하기
        int ans = 0;
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            Queue<Integer> deque = new LinkedList<>();
            boolean[] check = new boolean[N + 1];
            int num = 1;
            deque.offer(i);
            check[i] = true;
            while (!deque.isEmpty()) {
                int cur = deque.poll();

                for (int next : graph.get(cur)) {
                    if (!check[next]) {
                        check[next] = true;
                        num++;
                        deque.offer(next);
                    }
                }
            }
            dist[i] = num;
            if (num > ans) {
                ans = num;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= N; i++) {
            if (dist[i] == ans) {
                bw.append(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
