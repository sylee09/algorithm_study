package book1.ch7;

import java.util.ArrayDeque;

public class Ch7_1 {
    private int solution(int N, int K) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }


        while (deque.size() > 1) {
            for (int n = 1; n < K; n++) {
                deque.offer(deque.poll());
            }
            deque.poll();
        }
        return deque.poll();
    }

    public static void main(String[] args) {
        Ch7_1 solution = new Ch7_1();
        int answer = solution.solution(5, 2);
        System.out.println(answer);
    }
}
