package source3.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P6 {

    public int solution(int n, int[][] meetings){
        //[roomNum,끝나는시간]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            rooms.add(i);
        }
        int[] ans = new int[n];

        for (int[] m : meetings) {
            while (!pq.isEmpty() && m[0] >= pq.peek()[1]) {
                rooms.add(pq.poll()[0]);
            }
            if (rooms.isEmpty()) {
                int[] poll = pq.poll();
                ans[poll[0]]++;
                pq.offer(new int[]{poll[0], poll[1] + (m[1] - m[0])});
            } else {
                Integer room = rooms.pollFirst();
                ans[room]++;
                pq.offer(new int[]{room, m[1]});
            }
        }

        int max = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (max < ans[i]) {
                max = ans[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
