package source1.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon2468 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] arr = new int[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int answer = 1;
        for (int h = 1; h <= maxHeight; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Math.max(0, arr[i][j] - 1);
                }
            }

            boolean[][] check = new boolean[n][n];
            int potentialAnswer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > 0 && !check[i][j]) {
                        check[i][j] = true;
                        bfs(i, j, arr, check);
                        potentialAnswer++;
                    }
                }
            }

            answer = Math.max(answer, potentialAnswer);
        }

        System.out.println(answer);
    }

    static void bfs(int i, int j, int[][] arr, boolean[][] check) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + cur[0];
                int ny = dy[dir] + cur[1];

                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (!check[nx][ny] && arr[nx][ny] > 0) {
                        check[nx][ny] = true;
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
