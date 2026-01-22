package source1.ch04_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        int cnt = 0;
        char maxAlphabet=' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                cnt = 1;
                maxAlphabet = entry.getKey();
            } else if (entry.getValue() == max) {
                cnt++;
            }
        }

        if (cnt > 1) {
            System.out.println("?");
        } else {
            System.out.println(maxAlphabet);
        }

    }
}
