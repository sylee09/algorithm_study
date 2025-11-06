package ch02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon14502 {
    static int answer = 0;
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

        // 완전탐색
        func(arr, 0);

        System.out.println(answer);
    }

    static void func(int[][] arr, int cnt) {
        if (cnt == 3) {
            //바이러스 퍼짐
            boolean[][] check = new boolean[arr.length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 2 && !check[i][j]) {
                        spreadVirus(arr, i, j, check);
                    }
                }
            }

            // 안전 영역 구하기
            int area = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        area++;
                    }
                }
            }
            answer = Math.max(area, answer);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    int[][] copy = new int[arr.length][arr[0].length];
                    for (int x = 0; x < arr.length; x++) {
                        System.arraycopy(arr[x], 0, copy[x], 0, arr[x].length);
                    }
                    arr[i][j] = 1;
                    func(arr, cnt + 1);
                    for (int x = 0; x < arr.length; x++) {
                        System.arraycopy(copy[x], 0, arr[x], 0, copy[x].length);
                    }
                }
            }
        }
    }

    static void spreadVirus(int[][] arr, int i, int j, boolean[][] check) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j});
        check[i][j] = true;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (!check[nx][ny] && arr[nx][ny] == 0) {
                        arr[nx][ny] = 2;
                        check[nx][ny] = true;
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
