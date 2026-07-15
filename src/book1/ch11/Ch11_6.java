package book1.ch11;

import java.util.ArrayDeque;

public class Ch11_6 {

    public int solution(String[] maps) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][][] check = new boolean[maps.length][maps[0].length()][2];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    deque.offer(new int[]{i, j, 0, 0});
                    check[i][j][0] = true;
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            if (cur[2] == 1 && maps[cur[0]].charAt(cur[1]) == 'E') {
                return cur[3];
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length() && maps[nx].charAt(ny) != 'X' && !check[nx][ny][cur[2]]) {
                    if (maps[nx].charAt(ny) == 'L') {
                        deque.offer(new int[]{nx, ny, 1, cur[3] + 1});
                        check[nx][ny][cur[2]] = true;
                        check[nx][ny][1] = true;
                    } else {
                        deque.offer(new int[]{nx, ny, cur[2], cur[3] + 1});
                        check[nx][ny][cur[2]] = true;
                    }
                }
            }

        }
        return -1;
    }
}
