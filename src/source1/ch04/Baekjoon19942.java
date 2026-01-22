package source1.ch04;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon19942 {
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] conditionArr = new int[4];
        for (int i = 0; i < 4; i++) {
            conditionArr[i] = sc.nextInt();
        }
        ArrayList<int[]> ingredients = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] ingredient = new int[5];
            for (int j = 0; j < 5; j++) {
                ingredient[j] = sc.nextInt();
            }
            ingredients.add(ingredient);
        }

        // 백트래킹
        for (int limit = 1; limit <= N; limit++) {
            backtracking(conditionArr, ingredients, new ArrayList<Integer>(), 0, limit);
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
            for (int num : answerList) {
                System.out.print(num + 1 + " ");
            }
        }
    }

    // 백트래킹: 만약 조건 만족하고 총 값이 같으면 사전순 비교하고 더 작은것 answerList에 넣기
    // 총 값이 더 작다면 answer 갱신하고 answerList 갱신
    static void backtracking(int[] conditionArr, ArrayList<int[]> ingredients, ArrayList<Integer> list, int index, int limit) {
        if (list.size() == limit) {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int cost = 0;
            for (int idx : list) {
                int[] ints = ingredients.get(idx);
                a += ints[0];
                b += ints[1];
                c += ints[2];
                d += ints[3];
                cost += ints[4];
            }

            if (a >= conditionArr[0] && b >= conditionArr[1] && c >= conditionArr[2] && d >= conditionArr[3]) {
                if (answer == cost) {
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for (int idx : list) {
                        sb1.append(idx);
                    }
                    for (int idx : answerList) {
                        sb2.append(idx);
                    }
                    if (sb1.toString().compareTo(sb2.toString()) < 0) {
                        answerList.clear();
                        answerList.addAll(list);
                    }
                } else if (answer > cost) {
                    answerList.clear();
                    answerList.addAll(list);
                    answer = cost;
                }
            }
            return;
        }
        for (int i = index; i < ingredients.size(); i++) {
            list.add(i);
            backtracking(conditionArr, ingredients, list, i + 1, limit);
            list.remove(list.size() - 1);
        }
    }
}
