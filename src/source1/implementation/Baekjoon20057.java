package source1.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon20057 {
    static int n;
    static int[][] map;
    static int answer = 0;
    static int x, y, d;  // 토네이도 현재 위치와 방향

    // 방향: 0=←, 1=↓, 2=→, 3=↑  (토네이도가 도는 순서)
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    // ← 방향 기준, y(도착 칸)에서의 상대 좌표와 비율
    static int[][] baseOffset = {
            {-1, 1}, {1, 1}, // 1%
            {-2, 0}, {2, 0}, // 2%
            {-1, 0}, {1, 0}, // 7%
            {-1, -1}, {1, -1}, //10%
            {0, -2}  // 5%
    };
    static int[] ratio = {1, 1, 2, 2, 7, 7, 10, 10, 5};

    // offset[방향][k번 째 칸] [0 = 행 이동량, 1 = 열 이동량]
    static int[][][] offset = new int[4][9][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ← 표를 90도씩 반시계 회전해서 ↓, →, ↑ 표 만들기: (행, 열) -> (-열, 행)
        for (int k = 0; k < 9; k++) {
            int rowDiff = baseOffset[k][0];
            int colDiff = baseOffset[k][1];
            for (int dir = 0; dir < 4; dir++) {
                offset[dir][k][0] = rowDiff;
                offset[dir][k][1] = colDiff;
                int temp = rowDiff;
                rowDiff = -colDiff;
                colDiff = temp;
            }
        }

        // 달팽이 이동 : ←1 ↓1 →2 ↑2 ... ←(n-2) ↓(n-2) →(n-1) ↑(n-1), 마지막에 ←(n-1)
        x = n / 2;
        y = n / 2;
        d = 0;
        for (int len = 1; len < n; len++) {
            move(len); // 같은 길이로 두 방향
            move(len);
        }
        move(n - 1); // 마지막 줄: (0,0)까지

        System.out.println(answer);
    }

    // 현재 방향으로 len칸 이동하면서 모래를 흩뿌리고, 방향을 바꾼다.
    static void move(int len) {
        for (int k = 0; k < len; k++) {
            x += dx[d];
            y += dy[d];
            spread(x, y, d);
        }
        d = (d + 1) % 4;
    }

    // y = (x,y)의 모래를 방향 d 기준으로 흩뿌린다
    static void spread(int x, int y, int d) {
        int sand = map[x][y];
        if(sand==0) return;

        int moved = 0;
        for (int k = 0; k < 9; k++) {
            int amount = sand * ratio[k] / 100; // 소수점 버림
            moved += amount;
            addSand(x + offset[d][k][0], y + offset[d][k][1], amount);
        }

        // α: 진행 방향으로 한 칸 앞, 남은 모래 전부
        addSand(x + dx[d], y + dy[d], sand - moved);
        map[x][y] = 0;
    }

    // 격자 안이면 그 칸에 더하고, 밖이면 정답에 더한다
    static void addSand(int x, int y, int amount) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            answer += amount;
        } else {
            map[x][y] += amount;
        }
    }

}
