package source1.ch2;

import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon2870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();

        PriorityQueue<BigDecimal> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();

            for (char ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    if (sb.length() > 0) {
                        pq.offer(new BigDecimal(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }
            if (sb.length() > 0) {
                pq.offer(new BigDecimal(sb.toString()));
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
