package source1.ch04_5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Baekjoon18870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
            set.add(arr1[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        while (!set.isEmpty()) {
            int element = set.pollFirst();
            map.put(element, idx++);
        }

        StringBuilder ans = new StringBuilder();

        for (int element : arr1) {
            ans.append(map.get(element) + " ");
        }
        System.out.println(ans);
    }
}
