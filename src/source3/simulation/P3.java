package source3.simulation;

import java.util.ArrayDeque;

class P3 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] board){
        ArrayDeque<int[]> deque1 = new ArrayDeque<>();
        ArrayDeque<int[]> deque2 = new ArrayDeque<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    deque1.add(new int[]{i, j});
                }
                if (board[i][j] == 3) {
                    deque2.add(new int[]{i, j});
                }
            }
        }

        int time = 0;
        int dir1 = 0;
        int dir2 = 0;

        while (time < 10_000) {
            int[] cur1 = deque1.poll();
            int[] cur2 = deque2.poll();

            if (cur1[0] == cur2[0] && cur1[1] == cur2[1]) {
                return time;
            }

            int nx1 = cur1[0] + dx[dir1];
            int ny1 = cur1[1] + dy[dir1];

            if (nx1 < 0 || nx1 > 9 || ny1 < 0 || ny1 > 9 || board[nx1][ny1] == 1) {
                dir1 = (dir1 + 1) % 4;
                deque1.add(cur1);
            } else {
                deque1.add(new int[]{nx1, ny1});
            }

            int nx2 = cur2[0] + dx[dir2];
            int ny2 = cur2[1] + dy[dir2];

            if (nx2 < 0 || nx2 > 9 || ny2 < 0 || ny2 > 9 || board[nx2][ny2] == 1) {
                dir2 = (dir2 + 1) % 4;
                deque2.add(cur2);
            } else {
                deque2.add(new int[]{nx2, ny2});
            }

            time++;
        }

        return 0;
    }

    public static void main(String[] args){
        P3 T = new P3();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}