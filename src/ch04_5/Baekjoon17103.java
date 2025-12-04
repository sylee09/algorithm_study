package ch04_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon17103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            boolean[] arr = new boolean[N + 1];
            Arrays.fill(arr, true);
            arr[0] = false;
            arr[1] = false;
            for (int i = 2; i * i <= N; i++) {
                if (!arr[i]) {
                    continue;
                }
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = false;
                }
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 2; i <= N; i++) {
                if (arr[i]) {
                    map.put(i, N - i);
                }
            }

            int answer = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (key <= value && map.containsKey(value)) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
