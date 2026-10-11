package source1.implementation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon23288 {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int dir = 0;

    public static void main(String[] args) {
        int[] dice = new int[]{1, 6, 5, 2, 3, 4};
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int curX = 0;
        int curY = 0;
        int answer = 0;

        for (int mv = 0; mv < K; mv++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];
            int[] temp = new int[6];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                switch (dir) {
                    case 0:
                        temp[0] = dice[5];
                        temp[1] = dice[4];
                        temp[2] = dice[2];
                        temp[3] = dice[3];
                        temp[4] = dice[0];
                        temp[5] = dice[1];
                        dice = temp;
                        break;
                    case 1:
                        temp[0] = dice[3];
                        temp[1] = dice[2];
                        temp[2] = dice[0];
                        temp[3] = dice[1];
                        temp[4] = dice[4];
                        temp[5] = dice[5];
                        dice = temp;
                        break;
                    case 2:
                        temp[0] = dice[4];
                        temp[1] = dice[5];
                        temp[2] = dice[2];
                        temp[3] = dice[3];
                        temp[4] = dice[1];
                        temp[5] = dice[0];
                        dice = temp;
                        break;
                    case 3:
                        temp[0] = dice[2];
                        temp[1] = dice[3];
                        temp[2] = dice[1];
                        temp[3] = dice[0];
                        temp[4] = dice[4];
                        temp[5] = dice[5];
                        dice = temp;
                        break;
                }
                answer += bfs(arr, nx, ny) * arr[nx][ny];
                if (dice[1] > arr[nx][ny]) {
                    dir = (dir + 1) % 4;
                } else if (dice[1] < arr[nx][ny]) {
                    dir = (dir + 3) % 4;
                }
            } else {
                dir = (dir + 2) % 4;
                nx = curX + dx[dir];
                ny = curY + dy[dir];

                switch (dir) {
                    case 0:
                        temp[0] = dice[5];
                        temp[1] = dice[4];
                        temp[2] = dice[2];
                        temp[3] = dice[3];
                        temp[4] = dice[0];
                        temp[5] = dice[1];
                        dice = temp;
                        break;
                    case 1:
                        temp[0] = dice[3];
                        temp[1] = dice[2];
                        temp[2] = dice[0];
                        temp[3] = dice[1];
                        temp[4] = dice[4];
                        temp[5] = dice[5];
                        dice = temp;
                        break;
                    case 2:
                        temp[0] = dice[4];
                        temp[1] = dice[5];
                        temp[2] = dice[2];
                        temp[3] = dice[3];
                        temp[4] = dice[1];
                        temp[5] = dice[0];
                        dice = temp;
                        break;
                    case 3:
                        temp[0] = dice[2];
                        temp[1] = dice[3];
                        temp[2] = dice[1];
                        temp[3] = dice[0];
                        temp[4] = dice[4];
                        temp[5] = dice[5];
                        dice = temp;
                        break;
                }
                answer += bfs(arr, nx, ny) * arr[nx][ny];

                if (dice[1] > arr[nx][ny]) {
                    dir = (dir + 1) % 4;
                } else if (dice[1] < arr[nx][ny]) {
                    dir = (dir + 3) % 4;
                }
            }
            curX = nx;
            curY = ny;
        }
        System.out.println(answer);
    }

    static int bfs(int[][] arr, int curX, int curY) {
        boolean[][] check = new boolean[arr.length][arr[0].length];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{curX, curY});
        check[curX][curY] = true;
        int ret = 1;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && arr[nx][ny] == arr[curX][curY]) {
                    if (!check[nx][ny]) {
                        ret++;
                        check[nx][ny] = true;
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return ret;
    }
}
