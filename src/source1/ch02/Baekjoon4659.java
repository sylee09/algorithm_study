package source1.ch02;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Baekjoon4659 {

    public static void main(String[] args) {
        // 모음
        HashSet<Character> set = new HashSet<>();
        set.addAll(List.of('a', 'e', 'i', 'o', 'u'));

        // 입력
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("end")) {
                break;
            }

            boolean flag = true;
            // 규칙 1
            int count = 0;
            // 규칙 2
            int consecutiveCheck1 = 0;
            int consecutiveCheck2 = 0;
            // 규칙 3
            char before=' ';

            for (char ch : str.toCharArray()) {
                if (!flag) {
                    break;
                }
                if (set.contains(ch)) {
                    count++;
                    consecutiveCheck1++;
                    consecutiveCheck2 = 0;
                } else {
                    consecutiveCheck1 = 0;
                    consecutiveCheck2++;
                }
                if (before == ch && ch != 'e' && ch != 'o') {
                    flag = false;
                }
                before = ch;
                if (consecutiveCheck1 >= 3 || consecutiveCheck2 >= 3) {
                    flag = false;
                }
            }

            if (count == 0) {
                flag = false;
            }

            StringBuilder ans = new StringBuilder();
            if (flag) {
                ans.append("<" + str + ">" + " is acceptable.");
            } else {
                ans.append("<" + str + ">" + " is not acceptable.");
            }
            System.out.println(ans);
        }
    }
}
