package source2;

import java.util.Scanner;

public class P57 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] score = new int[N];
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        dfs(0, score, time, 0, 0, M);

        System.out.println(answer);
    }

    static void dfs(int idx, int[] score, int[] time, int sumScore, int sumTime, int limit) {
        if (idx >= score.length) {
            if (answer < sumScore && sumTime <= limit) {
                answer = sumScore;
            }
            return;
        }

        sumScore += score[idx];
        sumTime += time[idx];
        dfs(idx + 1, score, time, sumScore, sumTime, limit);
        sumScore -= score[idx];
        sumTime -= time[idx];
        dfs(idx + 1, score, time, sumScore, sumTime, limit);
    }
}
