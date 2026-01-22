package source1.ch05;

import java.util.Scanner;

public class Baekjoon17825 {
    static int answer = Integer.MIN_VALUE;
    static Node endNode;
    static Node node10;
    static Node node20;
    static Node node25;
    static Node node30;
    static Node node40;

    public static void main(String[] args) {
        // 세팅
        Node startNode = new Node(0);
        node10 = new Node(10);
        node20 = new Node(20);
        node25 = new Node(25);
        node30 = new Node(30);
        node40 = new Node(40);
        endNode = new Node(0);
        node40.redNext = endNode;

        Node cur = startNode;
        for (int i = 2; i <= 40; i += 2) {
            if (i == 10) {
                cur.redNext = node10;
            } else if (i == 20) {
                cur.redNext = node20;
            } else if (i == 30) {
                cur.redNext = node30;
            } else if (i == 40) {
                cur.redNext = node40;
            } else {
                cur.redNext = new Node(i);
            }
            cur = cur.redNext;
        }

        node10.blueNext = new Node(13);
        cur = node10.blueNext;
        cur.redNext = new Node(16);
        cur = cur.redNext;
        cur.redNext = new Node(19);
        cur = cur.redNext;
        cur.redNext = node25;

        node20.blueNext = new Node(22);
        cur = node20.blueNext;
        cur.redNext = new Node(24);
        cur = cur.redNext;
        cur.redNext = node25;

        node30.blueNext = new Node(28);
        cur = node30.blueNext;
        cur.redNext = new Node(27);
        cur = cur.redNext;
        cur.redNext = new Node(26);
        cur = cur.redNext;
        cur.redNext = node25;

        node25.redNext = new Node(30);
        cur = node25.redNext;
        cur.redNext = new Node(35);
        cur = cur.redNext;
        cur.redNext = node40;

        Node[] starts = new Node[4];
        for (int i = 0; i < 4; i++) {
            starts[i] = startNode;
        }

        // 입력
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // 백트랙킹
        func(starts, arr, 0, 0);

        System.out.println(answer);
    }

    static void func(Node[] starts, int[] arr, int level, int sum) {
        if (level == 10) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            Node original = starts[i];
            if (canMove(starts[i], starts, arr[level])) {
                starts[i] = move(starts[i], arr[level]);
                func(starts, arr, level + 1, sum + starts[i].val);
                starts[i] = original;
            }
        }
    }

    static Node move(Node cur, int mv) {
        if (cur.blueNext != null) {
            cur = cur.blueNext;
            mv--;
        }

        for (int i = 0; i < mv; i++) {
            cur = cur.redNext;
            if (cur == endNode) {
                break;
            }
        }
        return cur;
    }

    static boolean canMove(Node cur, Node[] starts, int mv) {
        if (cur == endNode) {
            return false;
        }

        if (cur.blueNext != null) {
            cur = cur.blueNext;
            mv--;
        }

        for (int i = 0; i < mv; i++) {
            cur = cur.redNext;
            if (cur == endNode) {
                break;
            }
        }

        for (Node n : starts) {
            if (n == cur) {
                return n == endNode;
            }
        }
        return true;
    }

    static class Node {
        int val;
        Node redNext;
        Node blueNext;

        public Node(int val) {
            this.val = val;
        }
    }
}
