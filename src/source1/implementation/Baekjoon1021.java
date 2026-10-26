package source1.implementation;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon1021 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayDeque<Integer> answerElement = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            answerElement.offer(sc.nextInt());
        }

        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        int answer = 0;

        while (!answerElement.isEmpty()) {
            if (list.peekFirst().equals(answerElement.peekFirst())) {
                list.poll();
                answerElement.poll();
            } else {
                int index = list.indexOf((Object) answerElement.peekFirst());
                int left = index;
                int right = list.size() - index - 1;

                if (left <= right) {
                    while (!(list.peekFirst().equals(answerElement.peekFirst()))) {
                        list.offer(list.poll());
                        answer++;
                    }
                } else {
                    while (!(list.peekFirst().equals(answerElement.peekFirst()))) {
                        list.offerFirst(list.pollLast());
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
