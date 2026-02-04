package source2;

import java.util.HashMap;
import java.util.Scanner;

public class P31 {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();

        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        char answer = '1';
        for (char ch : map.keySet()) {
            if (max < map.get(ch)) {
                max = map.get(ch);
                answer = ch;
            }
        }

        System.out.println(answer);

    }
}
