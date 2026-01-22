package source1.ch03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon12869 {
    static int[][] atk = new int[][]{{9, 3, 1}, {9, 1, 3}, {3, 9, 1},
            {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scvs = new int[N];
        boolean[][][] check = new boolean[61][61][61];

        for (int i = 0; i < N; i++) {
            scvs[i] = sc.nextInt();
        }

        // bfs
        //[hp1,hp2,hp3,atk횟수]
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[] first = new int[4];
        for (int i = 0; i < N; i++) {
            first[i] = scvs[i];
        }
        deque.offer(first);

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (checkFunc(cur)) {
                System.out.println(cur[3]);
                break;
            }

            for (int[] dir : atk) {
                int[] next = new int[4];
                for (int k = 0; k < 3; k++) {
                    next[k] = cur[k] - dir[k];
                    if (next[k] <= 0) {
                        next[k] = 0;
                    }
                }
                if (!check[next[0]][next[1]][next[2]]) {
                    check[next[0]][next[1]][next[2]] = true;
                    next[3] = cur[3] + 1;
                    deque.offer(next);
                }
            }
        }
    }

    static boolean checkFunc(int[] cur) {
        for (int i = 0; i < 3; i++) {
            if (cur[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
