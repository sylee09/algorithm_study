package ch03;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon15686 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 치킨들을 리스트에 저장
        ArrayList<int[]> chickens = new ArrayList<>();
        // 집들을 리스트에 저장
        ArrayList<int[]> houses = new ArrayList<>();

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
                if (arr[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }

        // 치킨 1개일때 부터 치킨 M개일때 구하기
        for (int i = 1; i <= M; i++) {
            func(chickens, i, new ArrayList<Integer>(), houses, 0);
        }

        System.out.println(answer);
    }

    static void func(ArrayList<int[]> chickens, int limit, ArrayList<Integer> list, ArrayList<int[]> houses, int startIdx) {
        if (list.size() == limit) {
            // 치킨중 최대 M개 골랐을때 도시의 치킨 거리의 최솟값 구하기
            // 뽑은 치킨집에서의 도시의 치킨 거리 구하기
            int dist = 0;
            for (int[] house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int idx : list) {
                    int[] chicken = chickens.get(idx);
                    minDist = Math.min(minDist, Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]));
                }
                dist += minDist;
            }
            answer = Math.min(answer, dist);
            return;
        }

        for (int i = startIdx; i < chickens.size(); i++) {
            list.add(i);
            func(chickens, limit, list, houses, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
