package source2;

import java.util.*;

public class P43 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            }
            return 0;
        });

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int[] element = {num, 0};
            deque.offer(element);
            pq.offer(num);
            if (i == M) {
                element[1] = 1;
            }
        }

        int answer = 1;
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int topPriority = pq.poll();
            if (poll[0] == topPriority) {
                if (poll[1] == 1) {
                    System.out.println(answer);
                    return;
                }
                answer++;
            } else {
                deque.offer(poll);
                pq.offer(topPriority);
            }
        }
    }
}
