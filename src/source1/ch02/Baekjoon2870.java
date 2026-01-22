package source1.ch02;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon2870 {

    public static void main(String[] args) {

        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();

        // 길이가 같으면 String 문자열 비교 다르면 문자열 길이가 큰게 더 큼
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() < b.length()) {
                return -1;
            } else if (a.length() > b.length()) {
                return 1;
            } else return a.compareTo(b);
        });

        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();

            for (int idx = 0; idx < line.length(); idx++) {
                char ch = line.charAt(idx);
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    if (!sb.toString().isEmpty()) {
                        StringBuilder num = new StringBuilder();

                        int subIdx = 0;
                        while (subIdx < sb.length() && sb.charAt(subIdx) == '0') {
                            subIdx++;
                        }
                        while (subIdx < sb.length()) {
                            num.append(sb.charAt(subIdx++));
                        }
                        if (num.toString().isEmpty()) {
                            pq.offer("0");
                        } else {
                            pq.offer(num.toString());
                        }
                        sb = new StringBuilder();
                    }
                }
            }
            if (!sb.toString().isEmpty()) {
                StringBuilder num = new StringBuilder();

                int subIdx = 0;
                while (subIdx < sb.length() && sb.charAt(subIdx) == '0') {
                    subIdx++;
                }
                while (subIdx < sb.length()) {
                    num.append(sb.charAt(subIdx++));
                }
                if (num.toString().isEmpty()) {
                    pq.offer("0");
                } else {
                    pq.offer(num.toString());
                }
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
