package source1.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon20057 {
    static int x, y, d, n;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[][] map;
    static int[][] offset = new int[][]{
            {-1, 1}, {1, 1}, //1
            {-2, 0}, {2, 0}, //2
            {-1, 0}, {1, 0}, //7
            {-1, -1}, {1, -1},//10
            {0, -2} //5
    };
    static int[] ratio = new int[]{1, 1, 2, 2, 7, 7, 10, 10, 5};
    static int[][][] trackingOffset = new int[4][9][2];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int k = 0; k < 9; k++) {
            int xDiff = offset[k][0];
            int yDiff = offset[k][1];

            for (int d = 0; d < 4; d++) {
                trackingOffset[d][k][0] = xDiff;
                trackingOffset[d][k][1] = yDiff;
                int temp = xDiff;
                xDiff = -yDiff;
                yDiff = temp;
            }
        }

        x = n / 2;
        y = n / 2;

        for (int len = 1; len < n; len++) {
            move(len);
            move(len);
        }
        move(n - 1);

        System.out.println(answer);
    }

    static void move(int len) {
        for (int i = 0; i < len; i++) {
            x += dx[d];
            y += dy[d];
            int amount = map[x][y];
            spread(amount);
        }

        d = (d + 1) % 4;
    }

    static void spread(int amount) {
        if (amount == 0) {
            return;
        }
        int totalMovedAmount = 0;
        for (int k = 0; k < 9; k++) {
            int nx = x + trackingOffset[d][k][0];
            int ny = y + trackingOffset[d][k][1];

            int movedAmount = amount * ratio[k] / 100;
            totalMovedAmount += movedAmount;

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                answer += movedAmount;
            } else {
                map[nx][ny] += movedAmount;
            }
        }
        int ax = x + dx[d];
        int ay = y + dy[d];
        int rest = amount - totalMovedAmount;
        if (ax < 0 || ax >= n || ay < 0 || ay >= n) {
            answer += rest;
        } else {
            map[ax][ay] += rest;
        }
        map[x][y] = 0;
    }
}