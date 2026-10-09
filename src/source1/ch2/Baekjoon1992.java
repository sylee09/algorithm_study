package source1.ch2;

import java.util.Scanner;

public class Baekjoon1992 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(String.valueOf(line.charAt(j)));
            }
        }
        String answer = "";
        answer += recursive(0, 0, N, arr);

        System.out.println(answer);
    }

    static String recursive(int startR, int startC, int limit, int[][] arr) {
        if (limit == 1) {
            return "" + arr[startR][startC];
        }
        if (check(startR, startC, limit, arr)) {
            return String.valueOf(arr[startR][startC]);
        } else {
            String temp = "";
            temp += "(";
            temp += recursive(startR, startC, limit / 2, arr);
            temp += recursive(startR, startC + limit / 2, limit / 2, arr);
            temp += recursive(startR + limit / 2, startC, limit / 2, arr);
            temp += recursive(startR + limit / 2, startC + limit / 2, limit / 2, arr);
            temp += ")";
            return temp;
        }
    }

    static boolean check(int startR, int startC, int limit, int[][] arr) {
        int num = arr[startR][startC];

        for (int i = startR; i < startR + limit; i++) {
            for (int j = startC; j < startC + limit; j++) {
                if (num != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
