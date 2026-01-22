package source1.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1911 {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int L = Integer.parseInt(split[1]);


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            split = line.split(" ");

            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            pq.offer(new int[]{start, end});
        }

        int answer = 0;

        int cur = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int start = poll[0];
            int end = poll[1];
            int dist = 0;

            if (cur >= start) {
                dist = end - cur;
            } else {
                dist = end - start;
                cur = start;
            }

            int num = (int) Math.ceil((double) dist / L);
            answer += num;
            cur = cur + num * L;
        }

        System.out.println(answer);

    }
}
