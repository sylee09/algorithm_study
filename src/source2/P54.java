package source2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P54 {

    public static void main(String[] args) {
        boolean[] check = new boolean[50_001];

        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();

        check[S] = true;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{S, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[0] == E) {
                System.out.println(cur[1]);
                return;
            }
            for (int next : new int[]{1, -1, 5}) {
                int nextStop = cur[0] + next;
                if (nextStop >= 1 && !check[nextStop]) {
                    deque.offer(new int[]{nextStop, cur[1] + 1});
                    check[nextStop] = true;
                }
            }
        }
    }
}
