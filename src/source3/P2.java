package source3;

import java.util.Arrays;

public class P2 {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public int[] solution(int[][] board, int k){
        int time = 0;
        int dir = 0;
        int curx = 0;
        int cury = 0;

        while (time < k) {
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];
            time++;

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 1) {
                dir = (dir + 1) % 4;
                continue;
            }

            curx = nx;
            cury = ny;
        }

        return new int[]{curx, cury};
    }

    public static void main(String[] args){
        P2 T = new P2();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
