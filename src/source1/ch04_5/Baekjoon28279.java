package source1.ch04_5;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon28279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            if (split[0].equals("1")) {
                deque.offerFirst(Integer.parseInt(split[1]));
            } else if (split[0].equals("2")) {
                deque.offer(Integer.parseInt(split[1]));
            } else if (split[0].equals("3")) {
                if (deque.isEmpty()) {
                    ans.append(-1 + "\n");
                } else {
                    ans.append(deque.poll() + "\n");
                }
            } else if (split[0].equals("4")) {
                if (deque.isEmpty()) {
                    ans.append(-1 + "\n");
                } else {
                    ans.append(deque.pollLast() + "\n");
                }
            } else if (split[0].equals("5")) {
                ans.append(deque.size() + "\n");
            } else if (split[0].equals("6")) {
                if (deque.isEmpty()) {
                    ans.append(1 + "\n");
                } else {
                    ans.append(0 + "\n");
                }
            } else if (split[0].equals("7")) {
                if (deque.isEmpty()) {
                    ans.append(-1 + "\n");
                } else {
                    ans.append(deque.getFirst() + "\n");
                }
            } else if (split[0].equals("8")) {
                if (deque.isEmpty()) {
                    ans.append(-1 + "\n");
                } else {
                    ans.append(deque.getLast() + "\n");
                }
            }
        }
        System.out.println(ans);
    }
}
