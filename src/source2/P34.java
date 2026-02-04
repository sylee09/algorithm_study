package source2;

import java.util.HashMap;
import java.util.Scanner;

public class P34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : T.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> subMap = new HashMap<>();
        for (int idx = 0; idx < T.length(); idx++) {
            subMap.put(S.charAt(idx), subMap.getOrDefault(S.charAt(idx), 0) + 1);
        }
        boolean flag = true;
        int answer = 0;

        for (char key : map.keySet()) {
            if (!subMap.containsKey(key) || subMap.get(key).intValue() != map.get(key).intValue()) {
                flag = false;
                break;
            }
        }
        if(flag) answer++;

        for (int idx = T.length(); idx < S.length(); idx++) {
            flag = true;
            subMap.put(S.charAt(idx - T.length()), subMap.get(S.charAt(idx - T.length())) - 1);
            if (subMap.get(S.charAt(idx - T.length())) == 0) {
                subMap.remove(S.charAt(idx - T.length()));
            }
            subMap.put(S.charAt(idx), subMap.getOrDefault(S.charAt(idx), 0) + 1);
            for (char key : map.keySet()) {
                if (!subMap.containsKey(key) || subMap.get(key).intValue() != map.get(key).intValue()) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        System.out.println(answer);
    }
}
