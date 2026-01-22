package source1.ch02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1068 {

    public static void main(String[] args) {
        //트리 만들기 위한 노드들 생성
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            Node node = new Node();
            node.num = i;
            nodes[i] = node;
        }

        Node root=null;
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = nodes[i];
                continue;
            }
            nodes[parent].child.add(nodes[i]);
            nodes[i].parent = nodes[parent];
        }

        int removed = sc.nextInt();
        // 루트노드 삭제한다면 답은 0
        if (removed == root.num) {
            System.out.println(0);
            return;
        }

        // 삭제노드 부모에서 삭제노드 삭제
        int removedIdx = 0;
        for (int idx = 0; idx < nodes[removed].parent.child.size(); idx++) {
            if (nodes[removed].parent.child.get(idx).num == removed) {
                removedIdx = idx;
                break;
            }
        }
        nodes[removed].parent.child.remove(removedIdx);
        nodes[removed].parent = null;


        // root를 시작으로 bfs
        int rootNodesCnt = 0;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.child.isEmpty()) {
                rootNodesCnt++;
            } else {
                for (Node neighbor : cur.child) {
                    if (neighbor != null) {
                        deque.offer(neighbor);
                    }
                }
            }
        }

        System.out.println(rootNodesCnt);
    }

    // 트리 자료구조
    static class Node {
        int num;
        ArrayList<Node> child = new ArrayList<>();
        Node parent;
    }
}
