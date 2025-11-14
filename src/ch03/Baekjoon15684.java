package ch03;

import java.util.Scanner;

public class Baekjoon15684 {
    static int N;
    static int M;
    static int H;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        boolean[][] check = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            check[a][b] = true;
        }
        for (int limit = 0; limit <= 3; limit++) {
            if (answer != Integer.MAX_VALUE) {
                break;
            }
            backtracking(1, 1, check, 0, limit);
        }

        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }

    static void backtracking(int h, int n, boolean[][] check, int cnt, int limit) {
        // 종료 조건1
        if (answer != Integer.MAX_VALUE) {
            return;
        }
        // 종료 조건2
        if (cnt == limit) {
            if (checkFunc(check)) {
                answer = cnt;
            }
            return;
        }
        // 종료 조건3
        if(h>H) return;

        if (n == N) {
            backtracking(h + 1, 1, check, cnt, limit);
            return;
        }

        if (!check[h][n]) {
            // 가로선이 연속하는 경우는 없다.
            boolean canPut =
                    (n == 1 || !check[h][n - 1]) &&
                            (n == N - 1 || !check[h][n + 1]);
            if (canPut) {
                check[h][n] = true;
                backtracking(h, n + 1, check, cnt + 1, limit);
                check[h][n] = false;
            }
        }
        backtracking(h, n + 1, check, cnt, limit);
    }

    static boolean checkFunc(boolean[][] check) {
        for (int n = 1; n <= N; n++) {
            int curN = n;
            for (int h = 1; h <= H; h++) {
                // 오른쪽으로 이동 가능한지 (curN < N 이고, curN 위치에 가로선이 있는지)
                if (curN < N && check[h][curN]) {
                    curN++;
                }
                // 왼쪽으로 이동 가능한지 (curN > 1 이고, 왼쪽 위치에 가로선이 있는지)
                else if (curN > 1 && check[h][curN - 1]) {
                    curN--;
                }
            }
            if (curN != n) {
                return false;
            }
        }
        return true;
    }
}
