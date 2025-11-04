package ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Baekjoon2910 {

    public static void main(String[] args) {
        //입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        // countMap, indexMap
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (!indexMap.containsKey(num)) {
                indexMap.put(num, i);
            }
        }

        //[count,index]
        //<[count,index], num>
        TreeMap<int[], Integer> treeMap = new TreeMap<>((a, b) -> {
            if (a[0] < b[0]) {
                return 1;
            } else if (a[0] > b[0]) {
                return -1;
            } else if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            treeMap.put(new int[]{entry.getValue(), indexMap.get(entry.getKey())}, entry.getKey());
        }

        StringBuilder ans = new StringBuilder();

        while (!treeMap.isEmpty()) {
            Map.Entry<int[], Integer> entry = treeMap.pollFirstEntry();
            for (int i = 0; i < entry.getKey()[0]; i++) {
                ans.append(entry.getValue() + " ");
            }
        }
        System.out.println(ans);

    }
}
