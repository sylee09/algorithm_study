package ch04;

import java.util.Scanner;

public class Baekjoon1285 {
    static int answer = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        boolean[][] arr = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                // H = false
                // T = true
                if (ch == 'H') {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }

        func(0, arr);
        System.out.println(answer);
    }

    static void func(int level, boolean[][] arr) {
        if (level == N) {
            int potentialAnswer = 0;
            // 행들은 고정되어 있으므로 열을 기준으로 for 문을 돌려 tail개수가 되는 값을 찾는다.
            for (int j = 0; j < N; j++) {
                int total = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j]) {
                        total++;
                    }
                }
                potentialAnswer += Math.min(total, N - total);
            }
            answer = Math.min(potentialAnswer, answer);
            return;
        }

        // 동전 뒤집지 않고 진행
        func(level + 1, arr);
        // 동전 뒤집고 진행
        for (int j = 0; j < N; j++) {
            arr[level][j] = !arr[level][j];
        }
        func(level + 1, arr);
        for (int j = 0; j < N; j++) {
            arr[level][j] = !arr[level][j];
        }
    }
}
