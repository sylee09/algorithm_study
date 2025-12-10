package ch05;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Baekjoon3273 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // <원소, 원소개수>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int goal = sc.nextInt();

        int ans = 0;

        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            int key = entry.getKey();
            int cnt = entry.getValue();
            int target = goal - key;
            // map이 traget을 포함하고 키가 target보다 작거나 같아야 중복되는 문제가 없다.
            if (map.containsKey(target) && key <= target) {
                if (cnt > map.get(target)) {
                    ans += map.get(target);
                } else {
                    ans += cnt;
                }
            }
        }

        System.out.println(ans);
    }
}
