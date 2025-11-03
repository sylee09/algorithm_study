package ch02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon2178 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        //입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N + 1][M + 1];
        sc.nextLine();

        // 그래프 그리기
        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();
            int idx = 1;
            for (char c : line.toCharArray()) {
                arr[i][idx++] = Integer.parseInt(String.valueOf(c));
            }
        }

        //bfs
        // [x,y,dist]
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] check = new boolean[N + 1][M + 1];
        check[1][1] = true;
        deque.offer(new int[]{1, 1, 1});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[0] == N && cur[1] == M) {
                System.out.println(cur[2]);
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                    if (!check[nx][ny] && arr[nx][ny] == 1) {
                        check[nx][ny] = true;
                        deque.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
    }
}
