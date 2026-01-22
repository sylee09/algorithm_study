package source1.ch03;

import java.util.Scanner;

public class Baekjoon14620 {
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        boolean[][] check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 백트래킹
        backtracking(0, 0, arr, check, 0);

        System.out.println(answer);
    }

    static void backtracking(int r, int c, int[][] arr, boolean[][] check, int cnt) {
        // 만약 cnt가 3이면 답 찾고 종료
        if (cnt == 3) {
            int area = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) {
                        area += arr[i][j];
                    }
                }
            }
            if (answer > area) {
                answer = area;
            }
            return;
        }

        if (r == N) {
            return;
        }

        if (c == N) {
            backtracking(r + 1, 0, arr, check, cnt);
            return;
        }

        // 꽃 심을 수 있으면
        if (checkFunc(r, c, check)) {
            boolean[][] copy = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(check[i], 0, copy[i], 0, N);
            }
            int[][] pos = new int[][]{{r, c}, {r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
            for (int[] next : pos) {
                int x = next[0];
                int y = next[1];
                check[x][y] = true;
            }
            // 심는다.
            backtracking(r, c + 1, arr, check, cnt + 1);
            for (int i = 0; i < N; i++) {
                System.arraycopy(copy[i], 0, check[i], 0, N);
            }
        }
        // 심지 않는다.
        backtracking(r, c + 1, arr, check, cnt);
    }

    static boolean checkFunc(int r, int c, boolean[][] check) {
        int[][] pos = new int[][]{{r, c}, {r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
        for (int[] next : pos) {
            int x = next[0];
            int y = next[1];
            if (x < 0 || x >= N || y < 0 || y >= N || check[x][y]) {
                return false;
            }
        }
        return true;
    }
}
