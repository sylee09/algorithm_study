package ch04;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon19942 {
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] condition = new int[4];

        for (int i = 0; i < 4; i++) {
            condition[i] = sc.nextInt();
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = sc.nextInt();
            }
            list.add(arr);
        }

        // 백트래킹
        ArrayList<Integer> l = new ArrayList<>();
        for (int limit = 1; limit <= N; limit++) {
            backtracking(condition, 0, list, l, limit);
        }
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
        if (answer != -1) {
            for (int num : answerList) {
                // 인덱스는 1부터
                System.out.print(num + 1 + " ");
            }
        }
    }

    static void backtracking(int[] condition, int startIdx, ArrayList<int[]> list, ArrayList<Integer> l, int limit) {
        // 종료 조건
        if (l.size() == limit) {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int cost = 0;
            for (int num : l) {
                a += list.get(num)[0];
                b += list.get(num)[1];
                c += list.get(num)[2];
                d += list.get(num)[3];
                cost += list.get(num)[4];
            }
            if (a >= condition[0] && b >= condition[1] && c >= condition[2] && d >= condition[3] && cost <= answer) {
                // 사전순 정렬을 위해
                if (answer == cost) {
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for (int num : l) {
                        sb1.append(num);
                    }
                    for (int num : answerList) {
                        sb2.append(num);
                    }
                    // answerList보다 l이 사전순으로 빠르다면 answerList 갱신
                    if (sb1.toString().compareTo(sb2.toString()) < 0) {
                        answerList.clear();
                        answerList.addAll(l);
                    }
                } else {
                    answer = cost;
                    answerList.clear();
                    answerList.addAll(l);
                }
            }
            return;
        }

        for (int i = startIdx; i < list.size(); i++) {
            l.add(i);
            backtracking(condition, i + 1, list, l, limit);
            l.remove(l.size() - 1);
        }
    }
}
