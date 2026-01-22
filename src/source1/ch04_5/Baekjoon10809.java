package source1.ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon10809 {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        for (int idx = 0; idx < line.length(); idx++) {
            if (!map.containsKey(line.charAt(idx))) {
                map.put(line.charAt(idx), idx);
            }
        }

        for (char a = 'a'; a <= 'z'; a++) {
            if (map.containsKey(a)) {
                System.out.print(map.get(a) + " ");
            } else {
                System.out.print(-1+" ");
            }
        }
    }
}
