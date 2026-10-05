package source1.ch2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon2178 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 1});
        boolean[][] check = new boolean[n][m];
        check[0][0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!check[nx][ny] && arr[nx][ny] == 1) {
                        if (nx == n - 1 && ny == m - 1) {
                            System.out.println(cur[2] + 1);
                            return;
                        }
                        deque.offer(new int[]{nx, ny, cur[2] + 1});
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
}
