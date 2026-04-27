package source3.sorting_thinking;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1 {
    public int[] solution(int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int cntA = getOnesCount(a);
            int cntB = getOnesCount(b);

            if (cntA < cntB) {
                return -1;
            } else if (cntA > cntB) {
                return 1;
            }
            return a - b;
        });

        for (int num : nums) {
            pq.offer(num);
        }

        int[] answer = new int[pq.size()];

        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        return answer;
    }


    private int getOnesCount(int num) {
        int cnt = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                cnt++;
            }
            num /= 2;
        }
        return cnt;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
