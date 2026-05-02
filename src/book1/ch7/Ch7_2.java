package book1.ch7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Ch7_2 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int p = progresses[i];
            int s = speeds[i];

            int in = (100 - p) / s;
            in += (100 - p) % s == 0 ? 0 : 1;

            queue.offer(in);
        }

        int top = -1;
        int idx = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (top == -1) {
                answer.add(1);
                top = poll;
            } else {
                if (top >= poll) {
                    answer.set(idx, answer.get(idx) + 1);
                } else {
                    answer.add(1);
                    top = poll;
                    idx++;
                }
            }
        }

        return answer.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static void main(String[] args) {
        Ch7_2 solution = new Ch7_2();
        int[] answer1 = solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(answer1));

        int[] answer2 = solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(answer2));
    }
}
