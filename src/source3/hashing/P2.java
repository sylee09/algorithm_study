package source3.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class P2 {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'e'; i++) {
            map.put(i, 0);
        }

        int max = 0;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.get(ch) + 1);
        }

        for (int v : map.values()) {
            max = Math.max(max, v);
        }

        for (int i = 0; i < 5; i++) {
            int n = map.get((char) ('a' + i));
            answer[i] = max - n;
        }
        return answer;
    }

    public static void main(String[] args){
        P2 T = new P2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
