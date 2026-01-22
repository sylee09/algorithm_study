package source1.ch05;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon15683 {
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][][] cctvs = new int[][][]{
                {},
                {{0}, {1}, {2}, {3}},
                {{0, 2}, {1, 3}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
                {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
                {{0, 1, 2, 3}}
        };

        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1 || arr[i][j] == 2 || arr[i][j] == 3 || arr[i][j] == 4 || arr[i][j] == 5) {
                    list.add(new int[]{i, j, arr[i][j]});
                }
            }
        }

        // 백트래킹
        func(arr, list, 0, cctvs);
        System.out.println(answer);
    }

    static void func(int[][] arr, ArrayList<int[]> list, int level, int[][][] cctvs) {
        if (level == list.size()) {
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            if (cnt < answer) {
                answer = cnt;
            }
            return;
        }

        // 원래 arr 복사
        int[][] original = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, original[i], 0, arr[i].length);
        }

        // 이동
        int[] cctv = list.get(level);
        int x = cctv[0];
        int y = cctv[1];
        int num = cctv[2];

        for (int[] element : cctvs[num]) {
            for (int dir : element) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (arr[nx][ny] != 6) {
                        arr[nx][ny] = -1;
                        nx += dx[dir];
                        ny += dy[dir];
                    } else {
                        break;
                    }
                }
            }
            func(arr, list, level + 1, cctvs);
            //원상복구
            for (int i = 0; i < arr.length; i++) {
                System.arraycopy(original[i], 0, arr[i], 0, arr[i].length);
            }
        }
    }

}
