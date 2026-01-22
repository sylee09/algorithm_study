package source1.ch04_5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Member> pq = new PriorityQueue<>((a, b) -> {
            if (a.age < b.age) {
                return -1;
            } else if (a.age > b.age) {
                return 1;
            } else if (a.number < b.number) {
                return -1;
            } else if (a.number > b.number) {
                return 1;
            }
            return 0;
        });
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int age = Integer.parseInt(split[0]);
            String name = split[1];
            pq.offer(new Member(age, name, i));
        }

        while (!pq.isEmpty()) {
            Member member = pq.poll();
            System.out.println(member.age + " " + member.name);
        }
    }

    static class Member {
        int age;
        String name;
        int number;

        public Member(int age, String name, int number) {
            this.age = age;
            this.name = name;
            this.number = number;
        }
    }
}
