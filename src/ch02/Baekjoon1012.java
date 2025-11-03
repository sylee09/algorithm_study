package ch02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon1012 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            boolean[][] arr = new boolean[N][M];
            for (int i = 1; i <= K; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                arr[x][y] = true;
            }

            // bfs
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 만약 true면 bfs하고 인접한 영역들 false로 변환
                    if (arr[i][j]) {
                        bfs(arr, i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(boolean[][] arr, int i, int j) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        arr[i][j] = false;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];
                if (nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr[0].length) {
                    if (arr[nextX][nextY]) {
                        arr[nextX][nextY] = false;
                        deque.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
