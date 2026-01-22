package source1.ch05;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static char[] operators = new char[]{'+', '-', '*', '/'};

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', sc.nextInt());
        map.put('-', sc.nextInt());
        map.put('*', sc.nextInt());
        map.put('/', sc.nextInt());

        // 백트래킹
        func(map, arr, 0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void func(HashMap<Character, Integer> map, int[] arr, int level, int sum) {
        if (level == arr.length - 1) {
            if (min > sum) {
                min = sum;
            }
            if (max < sum) {
                max = sum;
            }
            return;
        }

        for (char op : operators) {
            if (map.get(op) > 0) {
                if (op == '+') {
                    int result = sum + arr[level + 1];
                    map.put(op, map.get(op) - 1);
                    func(map, arr, level + 1, result);
                    map.put(op, map.get(op) + 1);
                } else if (op == '-') {
                    int result = sum - arr[level + 1];
                    map.put(op, map.get(op) - 1);
                    func(map, arr, level + 1, result);
                    map.put(op, map.get(op) + 1);
                } else if (op == '*') {
                    int result = sum * arr[level + 1];
                    map.put(op, map.get(op) - 1);
                    func(map, arr, level + 1, result);
                    map.put(op, map.get(op) + 1);
                } else if (op == '/') {
                    int result = sum / arr[level + 1];
                    map.put(op, map.get(op) - 1);
                    func(map, arr, level + 1, result);
                    map.put(op, map.get(op) + 1);
                }
            }
        }

    }
}
