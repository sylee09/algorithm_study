package ch04_5;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon2798 {
    static int answer = Integer.MAX_VALUE;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        backtracking(arr, new LinkedList<Integer>(), M, 0);
        System.out.println(answer);
    }

    static void backtracking(int[] arr, LinkedList<Integer> list, int M, int start) {
        if (list.size() == 3) {
            int sum = 0;
            for (int element : list) {
                sum += element;
            }
            if (sum > M) {
                return;
            }
            int diff = Math.abs(sum - M);

            if (minDiff > diff) {
                minDiff = diff;
                answer = sum;
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            backtracking(arr, list, M, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
