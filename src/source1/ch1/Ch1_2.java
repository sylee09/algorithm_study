package source1.ch1;

import java.util.HashMap;
import java.util.Scanner;

public class Ch1_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x = 'a'; x <= 'z'; x++) {
            map.put(x, 0);
        }

        String line = sc.nextLine();

        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder answer = new StringBuilder();

        for (char x = 'a'; x <= 'z'; x++) {
            answer.append(map.get(x) + " ");
        }
        System.out.println(answer);
    }
}
