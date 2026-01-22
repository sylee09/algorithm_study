package source1.ch04_5;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        StringBuilder ans = new StringBuilder();
        ans.append("<");

        while (!deque.isEmpty()) {
            for (int i = 1; i < K; i++) {
                deque.offer(deque.poll());
            }
            ans.append(deque.poll() + ", ");
        }
        ans.delete(ans.length() - 2, ans.length());
        ans.append(">");
        System.out.println(ans);
    }
}
