package source3.simulation;

import java.util.ArrayDeque;
import java.util.Arrays;

public class P2 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int[] solution(int[][] board, int k){
        int cnt = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        int dir = 1;

        while (cnt < k) {
            int[] cur = deque.poll();
            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 0) {
                deque.offer(new int[]{nx, ny});
            } else {
                deque.offer(cur);
                dir = (dir + 1) % 4;
            }
            cnt++;
        }
        return deque.poll();
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
