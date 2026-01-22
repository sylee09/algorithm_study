package source1.ch05;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon14889 {
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 완전탐색
        func(arr, 0, new HashSet<Integer>());
        System.out.println(answer);
    }

    static void func(int[][] arr, int start, HashSet<Integer> setA) {
        if (setA.size() == N / 2) {
            int teamA = 0;
            int teamB = 0;
            HashSet<Integer> setB = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (!setA.contains(i)) {
                    setB.add(i);
                }
            }

            for (int element1 : setA) {
                for (int element2 : setA) {
                    teamA += arr[element1][element2];
                }
            }

            for (int element1 : setB) {
                for (int element2 : setB) {
                    teamB += arr[element1][element2];
                }
            }

            answer = Math.min(answer, Math.abs(teamA - teamB));
            return;
        }

        for (int i = start; i < N; i++) {
            setA.add(i);
            func(arr, i + 1, setA);
            setA.remove(i);
        }
    }
}
