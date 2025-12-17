package ch05;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon2632 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr1 = new int[2 * m];
        int[] arr2 = new int[2 * n];

        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
            arr1[i + m] = arr1[i];
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
            arr2[i + n] = arr2[i];
        }

        // map에 arr1, arr2 각각의 가능한 누적 합들과 개수 저장
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        for (int sz = 1; sz <= m; sz++) {
            int sum = 0;
            for (int i = 0; i < sz; i++) {
                sum += arr1[i];
            }
            mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);

            if (sz == m) {
                continue;
            }

            // 시작 idx = 0 ~ m-1
            // 시작 idx 당 끝 idx : 0 + sz-1, 1 + sz-1, ..., m-1+sz-1
            for (int i = sz; i <= sz + m - 2; i++) {
                sum += arr1[i];
                sum -= arr1[i - sz];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }

        for (int sz = 1; sz <= n; sz++) {
            int sum = 0;
            for (int i = 0; i < sz; i++) {
                sum += arr2[i];
            }
            mapB.put(sum, mapB.getOrDefault(sum, 0) + 1);

            if (sz == n) {
                continue;
            }

            for (int i = sz; i <= n + sz - 2; i++) {
                sum += arr2[i];
                sum -= arr2[i - sz];
                mapB.put(sum, mapB.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0;
        // mapA에서 target 개수
        if (mapA.containsKey(target)) {
            answer += mapA.get(target);
        }

        // mapB에서 target 개수
        if (mapB.containsKey(target)) {
            answer += mapB.get(target);
        }

        // mapA와 mapB에서 key 합이 target인 경우
        for (int key : mapA.keySet()) {
            int key2 = target - key;
            if (mapB.containsKey(key2)) {
                answer += (mapB.get(key2) * mapA.get(key));
            }
        }

        System.out.println(answer);
    }
}
