package source2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P64 {
    static int areaNum = 0;
    static int[] dx = new int[]{-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] area = new int[N][N];
        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 1 && !check[i][j]) {
                    bfs(area, check, i, j);
                }
            }
        }

        System.out.println(areaNum);
    }

    static void bfs(int[][] area, boolean[][] check, int r, int c) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{r, c});
        check[r][c] = true;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] cur = deque.poll();

                for (int k = 0; k < dx.length; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (nx >= 0 && nx < check.length && ny >= 0 && ny < check.length && area[nx][ny] == 1 && !check[nx][ny]) {
                        deque.offer(new int[]{nx, ny});
                        check[nx][ny] = true;
                    }
                }
            }
        }
        areaNum++;
    }
}
