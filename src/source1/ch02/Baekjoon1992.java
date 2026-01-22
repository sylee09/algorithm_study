package source1.ch02;

import java.util.Scanner;

public class Baekjoon1992 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        // 재귀 함수 (범위 모두 0 or 1 일때까지 계속 반복
        StringBuilder sb = new StringBuilder();
        func(arr, arr.length, sb, 0, 0);
        System.out.println(sb);
    }

    static void func(int[][] arr, int N, StringBuilder sb, int x, int y) {
        if (N == 1) {
            sb.append(arr[x][y]);
            return;
        }

        int num = arr[x][y];
        // recursion 필요 체크
        boolean flag = false;
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (num != arr[i][j]) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            sb.append("(");
            func(arr, N / 2, sb, x, y);
            func(arr, N / 2, sb, x, y + N / 2);
            func(arr, N / 2, sb, x + N / 2, y);
            func(arr, N / 2, sb, x + N / 2, y + N / 2);
            sb.append(")");
        } else {
            sb.append(num);
        }
    }

}
