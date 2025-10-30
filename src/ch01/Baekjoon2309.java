package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2309 {
    static boolean found = false;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 완전탐색
        boolean[] check = new boolean[9];
        func(arr, new ArrayList<Integer>(), check);
    }

    static void func(int[] arr, ArrayList<Integer> list, boolean[] check) {
        if (found) {
            return;
        }
        if (list.size() == 7) {
            int sum = 0;
            for (int element : list) {
                sum += element;
            }
            if (sum == 100) {
                found = true;
                for (int element : list) {
                    System.out.println(element);
                }
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                list.add(arr[i]);
                func(arr, list, check);
                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
    }
}
