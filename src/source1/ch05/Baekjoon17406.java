package source1.ch05;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon17406 {
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ArrayList<int[]> rotates = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int s = sc.nextInt();
            rotates.add(new int[]{r, c, s});
        }

        // 백트래킹
        boolean[] check = new boolean[K];
        func(arr, rotates, check, 0);
        System.out.println(answer);
    }

    static void func(int[][] arr, ArrayList<int[]> rotates, boolean[] check, int cnt) {
        if (cnt == rotates.size()) {
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int j = 0; j < arr[0].length; j++) {
                    sum += arr[i][j];
                }
                if (answer > sum) {
                    answer = sum;
                }
            }
            return;
        }
        for (int i = 0; i < rotates.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                int[][] original = new int[arr.length][arr[0].length];
                for (int x = 0; x < arr.length; x++) {
                    System.arraycopy(arr[x], 0, original[x], 0, arr[0].length);
                }
                int r = rotates.get(i)[0];
                int c = rotates.get(i)[1];
                int s = rotates.get(i)[2];
                rotate(arr, s, r, c, 0);
                func(arr, rotates, check, cnt + 1);
                for (int x = 0; x < arr.length; x++) {
                    System.arraycopy(original[x], 0, arr[x], 0, arr[0].length);
                }
                check[i] = false;
            }
        }
    }

    // 회전 함수
    static void rotate(int[][] arr, int limitS, int startR, int startC, int s) {
        if (limitS < s) {
            return;
        }
        int endR = startR + 2 * s;
        int endC = startC + 2 * s;

        int curR = startR;
        int curC = startC;
        int curDir = 0;

        if (s > 0) {
            int prevValue = arr[curR][curC];
            arr[curR][curC] = arr[curR + 1][curC];
            do {
                curR += dir[curDir][0];
                curC += dir[curDir][1];
                if (curR > endR) {
                    curR = endR;
                    curC -= 1;
                    curDir++;
                } else if (curC > endC) {
                    curC = endC;
                    curR += 1;
                    curDir++;
                } else if (curC < startC) {
                    curC = startC;
                    curR -= 1;
                    curDir++;
                }
                int curValue = arr[curR][curC];
                arr[curR][curC] = prevValue;
                prevValue = curValue;
            } while (curR != startR || curC != startC);

            arr[curR][curC] = prevValue;
        }
        rotate(arr, limitS, startR - 1, startC - 1, s + 1);
    }
}
