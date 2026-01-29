package source2;

import java.util.Scanner;

public class P21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        // 행의 sum들
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
            answer = Math.max(sum, answer);
        }

        // 열의 sum들
        for (int j = 0; j < N; j++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i][j];
            }
            answer = Math.max(sum, answer);
        }

        // 대각선
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][i];
        }
        answer = Math.max(sum, answer);

        sum = 0;
        int col = N - 1;
        for (int i = 0; i < N; i++) {
            sum += arr[i][col];
            col--;
        }
        answer = Math.max(sum, answer);

        System.out.println(answer);
    }
}
