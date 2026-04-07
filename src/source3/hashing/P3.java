package source3.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class P3 {

    public int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int v : map.values()) {
            if (!set.contains(v)) {
                set.add(v);
            } else {
                int n = v;
                while (n > 0 && set.contains(n)) {
                    answer++;
                    n--;
                }
                if (n != 0) {
                    set.add(n);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P3 T = new P3();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
