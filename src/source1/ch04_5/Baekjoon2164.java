package source1.ch04_5;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon2164 {

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }

        while (true) {
            deque.poll();
            if (deque.size() == 1) {
                System.out.println(deque.poll());
                break;
            }
            deque.offer(deque.poll());
        }
    }
}
