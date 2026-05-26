package book1.ch10;

import java.util.ArrayList;

public class Ch10_1 {
    static int[] parent;

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    private static Boolean[] solution(int k, int[][] operations) {
        parent = new int[k];
        for (int i = 0; i <k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operations) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }
}
