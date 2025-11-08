package ch03;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon4179 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        // 지훈 좌표
        ArrayDeque<int[]> jihoon = new ArrayDeque<>();
        // 불 좌표
        ArrayDeque<int[]> fire = new ArrayDeque<>();

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'J') {
                    jihoon.add(new int[]{i, j, 0});
                }
                if (arr[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                }
            }
        }

        // 불 먼저 움직이고 다음 지훈 움직임
        // found가 true면 루프 종료
        boolean found = false;
        boolean[][] check = new boolean[R][C];
        check[jihoon.getFirst()[0]][jihoon.getFirst()[1]] = true;

        while (!jihoon.isEmpty()) {
            if (found) {
                break;
            }

            int fireSize = fire.size();

            for (int i = 0; i < fireSize; i++) {
                int[] curFire = fire.poll();
                for (int k = 0; k < 4; k++) {
                    int nextFireX = curFire[0] + dx[k];
                    int nextFireY = curFire[1] + dy[k];
                    if (nextFireX >= 0 && nextFireX < R && nextFireY >= 0 && nextFireY < C) {
                        if (arr[nextFireX][nextFireY] != 'F' && arr[nextFireX][nextFireY] != '#') {
                            arr[nextFireX][nextFireY] = 'F';
                            fire.offer(new int[]{nextFireX, nextFireY});
                        }
                    }
                }
            }

            int size = jihoon.size();
            for (int i = 0; i < size; i++) {
                int[] curJ = jihoon.poll();
                int curX = curJ[0];
                int curY = curJ[1];
                int curD = curJ[2];
                if (curX == R - 1 || curY == C - 1 || curX == 0 || curY == 0) {
                    found = true;
                    System.out.println(curD + 1);
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = curX + dx[k];
                    int ny = curY + dy[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (!check[nx][ny] && arr[nx][ny] == '.') {
                            check[nx][ny] = true;
                            jihoon.offer(new int[]{nx, ny, curD + 1});
                        }
                    }
                }
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }
    }
}
