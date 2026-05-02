package book1.ch7;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ch7_3 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();

        for (String card : cards1) {
            queue1.offer(card);
        }

        for (String card : cards2) {
            queue2.offer(card);
        }

        for (String g : goal) {
            boolean found = false;
            if (!queue1.isEmpty() && queue1.peek().equals(g)) {
                queue1.poll();
                found = true;
                continue;
            }

            if (!queue2.isEmpty() && queue2.peek().equals(g)) {
                queue2.poll();
                found = true;
                continue;
            }
            if (!found) {
                return "No";
            }
        }
        return "Yes";
    }
}
