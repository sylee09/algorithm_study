package ch05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon17144 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] dir1 = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static int[][] dir2 = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        int[][] arr = new int[R][C];
        ArrayList<int[]> cleaner = new ArrayList<>();
        ArrayList<int[]> dusts = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == -1) {
                    cleaner.add(new int[]{i, j});
                }
                if (arr[i][j] > 0) {
                    dusts.add(new int[]{i, j});
                }
            }
        }

        for (int i = 1; i <= T; i++) {
            // 미세먼지 확산
            spreadDustFunc(arr, dusts, cleaner);
            // 청소
            cleanFunc(cleaner, arr);
            // dusts 좌표 재조정
            dusts.clear();
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr[0].length; c++) {
                    if (arr[r][c] > 0) {
                        dusts.add(new int[]{r, c});
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    answer += arr[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    static void cleanFunc(ArrayList<int[]> cleaner, int[][] arr) {
        ArrayDeque<int[]> deque1 = new ArrayDeque<>();
        ArrayDeque<int[]> deque2 = new ArrayDeque<>();

        int r = cleaner.get(0)[0];
        int c = 1;
        int dirNum = 0;

        while (r != cleaner.get(0)[0] || c != cleaner.get(0)[1]) {
            deque1.offer(new int[]{r, c});
            r += dir1[dirNum][0];
            c += dir1[dirNum][1];

            if (c == arr[0].length) {
                c = arr[0].length - 1;
                r -= 1;
                dirNum++;
            }

            if (r == -1) {
                r = 0;
                c -= 1;
                dirNum++;
            }

            if (c == -1) {
                c = 0;
                r = 1;
                dirNum++;
            }
        }

        clean(arr, deque1);

        r = cleaner.get(1)[0];
        c = 1;
        dirNum = 0;

        while (r != cleaner.get(1)[0] || c != cleaner.get(1)[1]) {
            deque2.offer(new int[]{r, c});
            r += dir2[dirNum][0];
            c += dir2[dirNum][1];

            if (c == arr[0].length) {
                c = arr[0].length - 1;
                r += 1;
                dirNum++;
            }

            if (r == arr.length) {
                r = arr.length - 1;
                c -= 1;
                dirNum++;
            }

            if (c == -1) {
                c = 0;
                r -= 1;
                dirNum++;
            }
        }

        clean(arr, deque2);
    }

    static void clean(int[][] arr, ArrayDeque<int[]> deque) {
        int[] coordinate = deque.poll();
        int amount = arr[coordinate[0]][coordinate[1]];
        arr[coordinate[0]][coordinate[1]] = 0;

        while (!deque.isEmpty()) {
            coordinate = deque.poll();
            int prev = amount;
            amount = arr[coordinate[0]][coordinate[1]];
            arr[coordinate[0]][coordinate[1]] = prev;
        }
    }

    static void spreadDustFunc(int[][] arr, ArrayList<int[]> dusts, ArrayList<int[]> cleaner) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int[] dust : dusts) {
            int i = dust[0];
            int j = dust[1];
            int spreadAmount = arr[i][j] / 5;
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (arr[nx][ny] != -1) {
                        cnt++;
                        copy[nx][ny] += spreadAmount;
                    }
                }
            }
            copy[i][j] += (arr[i][j] - cnt * spreadAmount);
        }

        for (int[] c : cleaner) {
            copy[c[0]][c[1]] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(copy[i], 0, arr[i], 0, arr[i].length);
        }
    }
}
