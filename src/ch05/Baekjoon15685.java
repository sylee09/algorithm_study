package ch05;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon15685 {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 격자
        boolean[][] board = new boolean[101][101];

        for (int n = 0; n < N; n++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            // directions에 모든 방향을 넣는다.
            ArrayList<Integer> directions = new ArrayList<>();
            directions.add(d);

            for (int k = 0; k < g; k++) {
                int idx = directions.size() - 1;
                for (int i = idx; i >= 0; i--) {
                    directions.add((directions.get(i) + 1) % 4);
                }
            }

            board[x][y] = true;
            // list에 있는 방향 정보를 이용해서 드래곤 커브를 그린다.
            for (int dir : directions) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) {
                    break;
                }
                board[nx][ny] = true;
                x = nx;
                y = ny;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                if (board[i][j] && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
