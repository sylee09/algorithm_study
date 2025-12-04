package ch04_5;

import java.util.Scanner;

public class Baekjoon2346 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node head = null;
        Node cur = head;

        for (int i = 1; i <= N; i++) {
            if (head == null) {
                head = new Node(i, sc.nextInt(), null, null);
                cur = head;
            } else {
                cur.next = new Node(i, sc.nextInt(), null, cur);
                cur = cur.next;
            }
        }
        head.prev = cur;
        cur.next = head;
        cur = head;

        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(cur.num + " ");
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            int dir = cur.dir;

            if (cur == cur.next) {
                break;
            }
            if (dir > 0) {
                for (int i = 1; i <= dir; i++) {
                    cur = cur.next;
                }
            } else {
                for (int i = -1; i >= dir; i--) {
                    cur = cur.prev;
                }
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int num;
        int dir;
        Node next;
        Node prev;

        public Node(int num, int dir, Node next, Node prev) {
            this.num = num;
            this.dir = dir;
            this.next = next;
            this.prev = prev;
        }
    }
}
