package source1.ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon10807 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int n = sc.nextInt();

        if (countMap.containsKey(n)) {
            System.out.println(countMap.get(n));
        } else {
            System.out.println(0);
        }
    }
}
