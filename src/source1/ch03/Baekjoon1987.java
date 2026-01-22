package source1.ch03;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon1987 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] arr = new char[R][C];
        sc.nextLine();

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 백트래킹
        HashSet<Character> set = new HashSet<>();
        set.add(arr[0][0]);
        func(arr, set, 0, 0);

        System.out.println(answer);
    }

    static void func(char[][] arr, HashSet<Character> set, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (!checkFunc(arr, set, nx, ny)) {
                set.add(arr[nx][ny]);
                func(arr, set, nx, ny);
                set.remove(arr[nx][ny]);
            } else {
                if (answer < set.size()) {
                    answer = set.size();
                }
            }
        }
    }

    static boolean checkFunc(char[][] arr, HashSet<Character> set, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || set.contains(arr[i][j])) {
            return true;
        }
        return false;
    }
}
