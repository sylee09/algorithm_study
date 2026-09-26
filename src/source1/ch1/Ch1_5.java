package source1.ch1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ch1_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            char first = name.charAt(0);

            map.put(first, map.getOrDefault(first, 0) + 1);
        }

        StringBuilder answer = new StringBuilder();

        while (!map.isEmpty()) {
            Map.Entry<Character, Integer> entry = map.pollFirstEntry();
            if (entry.getValue() >= 5) {
                answer.append(entry.getKey());
            }
        }

        if (answer.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(answer);
        }
    }
}
