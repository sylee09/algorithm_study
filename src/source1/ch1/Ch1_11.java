package source1.ch1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ch1_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>((a, b) -> a.compareTo(b));

        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int oddNum = 0;

        for (int v : map.values()) {
            if (v % 2 != 0) {
                oddNum++;
            }
            if (oddNum > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        char[] answerArr = new char[line.length()];

        int left = 0;
        int right = answerArr.length - 1;

        while (!map.isEmpty()) {
            Map.Entry<Character, Integer> entry = map.pollFirstEntry();
            char ch = entry.getKey();
            int num = entry.getValue();

            for (int x = 0; x < num / 2; x++) {
                answerArr[left] = ch;
                answerArr[right] = ch;
                left++;
                right--;
            }

            if (num % 2 != 0) {
                answerArr[line.length() / 2] = ch;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char ch : answerArr) {
            answer.append(ch);
        }

        System.out.println(answer.toString());
    }
}
