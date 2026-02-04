package source2;

import java.util.HashMap;
import java.util.Scanner;

public class P32 {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        for (char ch : line1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : line2.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                System.out.println("NO");
                return;
            }
        }

        if (map.size() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
