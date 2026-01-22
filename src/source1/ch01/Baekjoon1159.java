package source1.ch01;

import java.util.*;

public class Baekjoon1159 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        // HashMap<첫글자, count>
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            map.put(line.charAt(0), map.getOrDefault(line.charAt(0), 0) + 1);
        }

        // 정답 구하기
        ArrayList<Character> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 5) {
                ans.add(entry.getKey());
            }
        }

        if (ans.size() == 0) {
            System.out.println("PREDAJA");
        } else {
            for (char c : ans) {
                System.out.print(c);
            }
        }

    }
}
