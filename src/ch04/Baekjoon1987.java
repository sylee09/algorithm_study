package ch04;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon1987 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int answer = 0;
    static int R;
    static int C;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // backtracking
        boolean[][] check = new boolean[R][C];
        HashSet<Character> set = new HashSet<>();
        check[0][0] = true;
        set.add(arr[0][0]);
        backtracking(check, arr, set, 0, 0, 1);
        System.out.println(answer);
    }

    static void backtracking(boolean[][] check, char[][] arr, HashSet<Character> set, int r, int c, int cnt) {
        if (answer < cnt) {
            answer = cnt;
        }

        for (int k = 0; k < 4; k++) {
            int nr = r + dx[k];
            int nc = c + dy[k];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (set.contains(arr[nr][nc])) {
                    continue;
                }
                if (check[nr][nc]) {
                    continue;
                }
                set.add(arr[nr][nc]);
                check[nr][nc] = true;
                backtracking(check, arr, set, nr, nc, cnt + 1);
                check[nr][nc] = false;
                set.remove(arr[nr][nc]);
            }
        }
    }
}
