package source2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P62 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] board = new boolean[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                int n = sc.nextInt();
                if (n == 1) {
                    board[i][j] = true;
                }
            }
        }

        ArrayDeque<int[]> deque = new ArrayDeque<>();

        deque.offer(new int[]{0, 0, 0});
        board[0][0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (cur[0] == 6 && cur[1] == 6) {
                System.out.println(cur[2]);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];

                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && !board[nx][ny]) {
                    board[nx][ny] = true;
                    deque.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
