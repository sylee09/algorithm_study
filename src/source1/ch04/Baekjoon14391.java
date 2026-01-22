package source1.ch04;

import java.util.Scanner;

public class Baekjoon14391 {
    static int N;
    static int M;
    static int answer = 0;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        // 백트래킹
        boolean[][] check = new boolean[N][M];
        backtracking(arr, check, 0, 0);
        System.out.println(answer);
    }

    static void backtracking(int[][] arr, boolean[][] check, int idx, int accumulated) {
        if (idx == N * M) {
            if (answer < accumulated) {
                answer = accumulated;
            }
            return;
        }

        int r = idx / M;
        int c = idx % M;

        if (check[r][c]) {
            backtracking(arr, check, idx + 1, accumulated);
            return;
        }

        // 1. 현재 값에서 가로나 세로로 늘리지 않는다.
        check[r][c] = true;
        backtracking(arr, check, idx + 1, accumulated + arr[r][c]);

        // 2. 세로로 늘림
        int i;
        int num = arr[r][c];
        for (i = r + 1; i < N; i++) {
            if (check[i][c]) {
                break;
            }
            check[i][c] = true;
            num = num * 10 + arr[i][c];
            backtracking(arr, check, idx + 1, accumulated + num);
        }
        for (int ii = r + 1; ii < i; ii++) {
            check[ii][c] = false;
        }

        // 3. 가로로 늘림
        int j;
        num = arr[r][c];
        for (j = c + 1; j < M; j++) {
            if (check[r][j]) {
                break;
            }
            check[r][j] = true;
            num = num * 10 + arr[r][j];
            backtracking(arr, check, idx + 1, accumulated + num);
        }
        for (int jj = c + 1; jj < j; jj++) {
            check[r][jj] = false;
        }

        check[r][c] = false;
    }
}
