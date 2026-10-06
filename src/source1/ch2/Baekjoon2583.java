package source1.ch2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon2583 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        boolean[][] check = new boolean[n][m];

        for (int a = 0; a < k; a++) {
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    check[x][y] = true;
                }
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        int numArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    bfs(i, j, check, answerList);
                    numArea++;
                }
            }
        }

        System.out.println(numArea);
        answerList.sort((a, b) -> a.compareTo(b));

        for (int element : answerList) {
            System.out.print(element + " ");
        }
    }

    static void bfs(int i, int j, boolean[][] check, ArrayList<Integer> answerList) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        int area = 1;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if (nx >= 0 && nx < check.length && ny >= 0 && ny < check[0].length) {
                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        area++;
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        answerList.add(area);
    }
}
