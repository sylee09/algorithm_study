package source1.ch2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon1012 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            boolean[][] check = new boolean[n][m];
            int[][] arr = new int[n][m];

            ArrayDeque<int[]> baechoo = new ArrayDeque<>();

            for (int a = 0; a < k; a++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                baechoo.offer(new int[]{x, y});
                arr[x][y] = 1;
            }

            int answer = 0;


            for (int[] b : baechoo) {
                int x = b[0];
                int y = b[1];

                if (check[x][y]) {
                    continue;
                }
                answer++;

                ArrayDeque<int[]> deque = new ArrayDeque<>();
                deque.offer(new int[]{x, y});
                check[x][y] = true;

                while (!deque.isEmpty()) {
                    int[] cur = deque.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = dx[dir] + cur[0];
                        int ny = dy[dir] + cur[1];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (arr[nx][ny] == 1 && !check[nx][ny]) {
                                check[nx][ny] = true;
                                deque.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
