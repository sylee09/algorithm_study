package source1.ch03;

import java.util.Scanner;

public class Baekjoon1189 {
    static int R;
    static int C;
    static int K;
    static int answer = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 백트랙킹
        boolean[][] check = new boolean[R][C];
        check[R - 1][0] = true;
        backtracking(R - 1, 0, 1, check, arr);
        System.out.println(answer);
    }

    static void backtracking(int r, int c, int cnt, boolean[][] check, char[][] arr) {
        if (r == 0 && c == C - 1) {
            if (cnt == K) {
                answer++;
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = r + dx[k];
            int ny = c + dy[k];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!check[nx][ny] && arr[nx][ny] != 'T') {
                    check[nx][ny] = true;
                    backtracking(nx, ny, cnt + 1, check, arr);
                    check[nx][ny] = false;
                }
            }
        }
    }
}
