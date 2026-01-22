package source1.ch02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon2468 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 0;
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        // 비는 1 ~ max까지 올수 있음 max 이상이면 안전 영역 0
        // 비가 0일때 안전영역은 1
        int answer = 1;

        for (int k = 1; k <= max; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] -= 1;
                    if (arr[i][j] <= 0) {
                        arr[i][j] = 0;
                    }
                }
            }
            boolean[][] check = new boolean[N + 1][N + 1];
            int area = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > 0 && !check[i][j]) {
                        bfs(i, j, arr, check);
                        area++;
                    }
                }
            }

            answer = Math.max(area, answer);
        }

        System.out.println(answer);
    }

    static void bfs(int i, int j, int[][] arr, boolean[][] check) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        check[i][j] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx > 0 && nx < arr.length && ny > 0 && ny < arr[0].length) {
                    if (!check[nx][ny] && arr[nx][ny] > 0) {
                        deque.offer(new int[]{nx, ny});
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
}
