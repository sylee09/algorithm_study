package source1.ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon10816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int M = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                ans.append(map.get(num) + " ");
            } else {
                ans.append(0 + " ");
            }
        }
        System.out.println(ans);
    }
}
