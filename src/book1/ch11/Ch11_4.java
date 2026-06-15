package book1.ch11;

import java.util.ArrayDeque;

public class Ch11_4 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] maps) {
        int r = maps.length;
        int c = maps[0].length;
        boolean[][] check = new boolean[r][c];

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 1});
        check[0][0] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[0] == r - 1 && cur[1] == c - 1) {
                return cur[2];
            }
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (maps[nx][ny] == 1 && !check[nx][ny]) {
                        deque.offer(new int[]{nx, ny, cur[2] + 1});
                        check[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch11_4 solution = new Ch11_4();
        System.out.println(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));

    }
}
