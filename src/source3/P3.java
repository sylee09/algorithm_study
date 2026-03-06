package source3;

import java.util.ArrayDeque;

public class P3 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] board) {

        ArrayDeque<int[]> deque1 = new ArrayDeque<>();
        ArrayDeque<int[]> deque2 = new ArrayDeque<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    deque1.offer(new int[]{i, j, 0});
                }
                if (board[i][j] == 3) {
                    deque2.offer(new int[]{i, j, 0});
                }
            }
        }

        int curTime = 0;

        while (curTime < 10_000) {
            int[] cur = deque1.poll();
            int[] puppy = deque2.poll();

            if (cur[0] == puppy[0] && cur[1] == puppy[1]) {
                return curTime;
            }

            // 현수 이동
            int dirCur = cur[2];
            int nx = cur[0] + dx[dirCur];
            int ny = cur[1] + dy[dirCur];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 1) {
                dirCur = (dirCur + 1) % 4;
                deque1.offer(new int[]{cur[0], cur[1], dirCur});
            } else {
                deque1.offer(new int[]{nx, ny, dirCur});
            }

            // 강아지 이동
            int dirPuppy = puppy[2];
            int nextPuppyX = puppy[0] + dx[dirPuppy];
            int nextPuppyY = puppy[1] + dy[dirPuppy];

            if (nextPuppyX < 0 || nextPuppyX >= board.length || nextPuppyY < 0 || nextPuppyY >= board[0].length || board[nextPuppyX][nextPuppyY] == 1) {
                dirPuppy = (dirPuppy + 1) % 4;
                deque2.offer(new int[]{puppy[0], puppy[1], dirPuppy});
            } else {
                deque2.offer(new int[]{nextPuppyX, nextPuppyY, dirPuppy});
            }
            curTime++;
        }
        return 0;
    }

    public static void main(String[] args) {
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
