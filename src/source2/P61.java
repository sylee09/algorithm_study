package source2;

import java.util.Scanner;

public class P61 {
    static boolean[][] board = new boolean[7][7];
    static int answer = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                int n = sc.nextInt();
                if (n == 1) {
                    board[i][j] = true;
                }
            }
        }

        board[0][0] = true;
        dfs(board, 0, 0);

        System.out.println(answer);
    }

    static void dfs(boolean[][] board, int curR, int curC) {
        if (curR == 6 && curC == 6) {
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = curR + dx[i];
            int ny = curC + dy[i];

            if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && !board[nx][ny]) {
                board[nx][ny] = true;
                dfs(board, nx, ny);
                board[nx][ny] = false;
            }
        }
    }
}
