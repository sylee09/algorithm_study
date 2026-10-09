package source1.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        long C = Long.parseLong(split[1]);

        LinkedHashMap<Long, Integer> map = new LinkedHashMap<>();

        line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            map.put(Long.parseLong(token), map.getOrDefault(Long.parseLong(token), 0) + 1);
        }

        int idx = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] > b[2]) {
                return -1;
            } else if (a[2] < b[2]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        for (long key : map.keySet()) {
            pq.offer(new long[]{key, idx, map.get(key)});
            idx++;
        }

        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            for (int cnt = 0; cnt < poll[2]; cnt++) {
                answer.append(poll[0]+" ");
            }
        }

        System.out.println(answer.toString());

    }
}
