package ch01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon9375 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                String line = sc.nextLine();
                String[] split = line.split(" ");
                map.put(split[1], map.getOrDefault(split[1], 0) + 1);
            }
            int answer = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                answer *= (entry.getValue() + 1);
            }
            System.out.println(answer-1);
        }
    }
}
