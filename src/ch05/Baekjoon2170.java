package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon2170 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

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
            String line = br.readLine();
            String[] split = line.split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            pq.offer(new int[]{start, end});
        }

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        int length = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start1 = cur[0];
            int end1 = cur[1];
            // 현재까지 그은 선의 end 보다 새로 긋는 선의 start가 뒤에있음
            if (end < start1) {
                length += (end - start);
                start = start1;
                end = end1;
            } else {
                // 새로 긋는 선의 end가 현재까지 그은 선의 end보다 뒤에 있음
                if (end < end1) {
                    end = end1;
                }
            }
        }
        // 마지막에 현재 새로그은 선의 길이를 더함
        length += (end - start);

        System.out.println(length);
    }
}
