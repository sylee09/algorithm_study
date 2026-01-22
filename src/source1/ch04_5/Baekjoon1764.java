package source1.ch04_5;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String name = sc.nextLine();
            set.add(name);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            String name = sc.nextLine();
            if (set.contains(name)) {
                pq.offer(name);
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
