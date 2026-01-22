package source1.ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = sc.nextLine();
        }

        int cnt = 0;

        for (String str : strs) {
            boolean flag = true;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i))) {
                    if (i - 1 != map.get(str.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
                map.put(str.charAt(i), i);
            }

            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
