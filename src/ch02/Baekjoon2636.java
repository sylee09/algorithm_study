package ch02;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2636 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cheeses = 0;
        int time = 0;
        // <시간, 시간별 치즈개수>
        HashMap<Integer, Integer> mapTimeCheese = new HashMap<>();
        while (true) {
            // 경계 치즈 찾기
            Queue<int[]> border = new ArrayDeque<>();
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            boolean[][] check = new boolean[N][M];
            deque.offer(new int[]{0, 0});
            check[0][0] = true;

            while (!deque.isEmpty()) {
                int[] cur = deque.poll();
                int curX = cur[0];
                int curY = cur[1];

                for (int k = 0; k < 4; k++) {
                    int nx = curX + dx[k];
                    int ny = curY + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (!check[nx][ny] && arr[nx][ny] == 0) {
                            deque.offer(new int[]{nx, ny});
                            check[nx][ny] = true;
                        }
                        if (arr[nx][ny] == 1) {
                            border.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            // 치즈 개수 새기
            cheeses = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) {
                        cheeses++;
                    }
                }
            }
            mapTimeCheese.put(time, cheeses);

            // 만약 경계 치즈가 없다면 모두 녹음
            if (border.isEmpty()) {
                break;
            }

            // 경계치즈 녹이기
            while (!border.isEmpty()) {
                int[] b = border.poll();
                arr[b[0]][b[1]] = 0;
            }
            time++;
        }

        System.out.println(time);
        System.out.println(mapTimeCheese.get(time - 1));
    }
}
