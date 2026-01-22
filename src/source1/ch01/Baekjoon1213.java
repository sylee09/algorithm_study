package source1.ch01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Baekjoon1213 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        // 해시맵 <알파벳,cnt>
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // cnt가 모두 짝수거나 홀수가 1개고 나머지 모두 짝수면 가능
        boolean isAllEven = true;
        int oddCount = 0;

        for (int cnt : map.values()) {
            if (cnt % 2 != 0) {
                oddCount++;
                isAllEven = false;
            }
        }
        if (!isAllEven && oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            char[] answer = new char[line.length()];
            int idx = 0;
            while (!map.isEmpty()) {
                Map.Entry<Character, Integer> entry = map.firstEntry();
                if (entry.getValue() % 2 == 0) {
                    answer[idx] = entry.getKey();
                    answer[line.length() - 1 - idx] = entry.getKey();
                    idx++;
                    map.put(entry.getKey(), map.get(entry.getKey()) - 2);
                } else {
                    answer[line.length() / 2] = entry.getKey();
                    map.put(entry.getKey(), map.get(entry.getKey()) - 1);
                }
                if (map.get(entry.getKey()) == 0) {
                    map.remove(entry.getKey());
                }
            }
            StringBuilder ans = new StringBuilder();

            for (char a : answer) {
                ans.append(a);
            }
            System.out.println(ans);
        }
    }
}
