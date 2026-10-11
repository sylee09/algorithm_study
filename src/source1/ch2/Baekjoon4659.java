package source1.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baekjoon4659 {

    public static void main(String[] args) throws IOException {
        Set<Character> set1 = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> set2 = new HashSet<>();
        for (char x = 'a'; x <= 'z'; x++) {
            if (set1.contains(x)) {
                continue;
            }
            set2.add(x);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                return;
            }
            boolean containsCondition = false;
            int countCondition1 = 0;
            int countCondition2 = 0;
            char prev = '1';
            boolean flag = true;

            for (char ch : line.toCharArray()) {
                if (ch != 'e' && ch != 'o') {
                    if (ch == prev) {
                        flag = false;
                        break;
                    }
                }
                prev = ch;
                if (set1.contains(ch)) {
                    countCondition2 = 0;
                    containsCondition = true;
                    countCondition1++;
                } else {
                    countCondition1 = 0;
                    countCondition2++;
                }

                if (countCondition1 == 3 || countCondition2 == 3) {
                    flag = false;
                    break;
                }
            }

            if (!containsCondition) {
                flag = false;
            }

            if (flag) {
                System.out.println("<" + line + ">" + " is acceptable.");
            } else {
                System.out.println("<" + line + ">" + " is not acceptable.");
            }
        }
    }
}
