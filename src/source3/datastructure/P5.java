package source3.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P5 {

    public int[] solution(int[][] tasks){
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            } else if (a[2] < b[2]) {
                return -1;
            } else if (a[2] > b[2]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> {
            if (a[2] < b[2]) {
                return -1;
            } else if (a[2] > b[2]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        int idx = 0;
        for (int[] t : tasks) {
            pq1.offer(new int[]{idx++, t[0], t[1]});
        }

        int[] answer = new int[tasks.length];

        int curTime = 0;
        int rank = 0;

        while (true) {
            while (!pq1.isEmpty() && pq1.peek()[1] <= curTime) {
                int[] poll = pq1.poll();
                pq2.offer(poll);
            }
            if (!pq1.isEmpty() && pq2.isEmpty()) {
                curTime = pq1.peek()[1];
            }
            if (pq1.isEmpty() && pq2.isEmpty()) {
                break;
            }
            if (!pq2.isEmpty()) {
                int[] poll = pq2.poll();
                curTime += poll[2];
                answer[rank++] = poll[0];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }

}
