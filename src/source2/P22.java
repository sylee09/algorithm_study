package source2;

import java.util.Scanner;

public class P22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] > arr[i][j - 1]
                        && arr[i][j] > arr[i][j + 1]
                        && arr[i][j] > arr[i - 1][j]
                        && arr[i][j] > arr[i + 1][j]
                ) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
