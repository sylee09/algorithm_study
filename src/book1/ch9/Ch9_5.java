package book1.ch9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ch9_5 {

    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> list = new ArrayList<>();
        int idx = 1;
        for (int[] node : nodeinfo) {
            int x = node[0];
            int y = node[1];
            Node newNode = new Node(idx++, x, y, null, null);
            list.add(newNode);
        }
        Collections.sort(list);

        Node root = list.get(0);    // 맨 처음 노드는 무조건 루트
        for (int i = 1; i < list.size(); i++) {
            Node parent = root;
            while (true) {
                Node child = list.get(i);
                if (child.x < parent.x) {
                    if (parent.left == null) {
                        parent.left = child;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = child;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();
        ArrayList<Integer> preorderList = new ArrayList<>();
        ArrayList<Integer> postorderList = new ArrayList<>();
        preorder(root, preorderList);
        postorder(root, postorderList);

        answerList.addAll(List.of(preorderList, postorderList));

        int[][] result = new int[2][];

        for (int i = 0; i < result.length; i++) {
            result[i] = new int[answerList.get(i).size()];
            for (int j = 0; j < answerList.get(i).size(); j++) {
                result[i][j] = answerList.get(i).get(j);
            }
        }

        return result;
    }

    static void preorder(Node root, ArrayList<Integer> preorderList) {
        if (root == null) {
            return;
        }
        preorderList.add(root.num);
        preorder(root.left, preorderList);
        preorder(root.right, preorderList);
    }

    static void postorder(Node root, ArrayList<Integer> postorderList) {
        if (root == null) {
            return;
        }
        postorder(root.left, postorderList);
        postorder(root.right, postorderList);
        postorderList.add(root.num);
    }

    static class Node implements Comparable<Node> {

        int num;
        int x;
        int y;
        Node left;
        Node right;
        public Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (y > o.y) {
                return -1;
            } else if (y < o.y) {
                return 1;
            } else if (x > o.x) {
                return 1;
            } else if (x < o.x) {
                return -1;
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        Ch9_5 solution = new Ch9_5();
        int[][] answer = solution.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
    }
}
