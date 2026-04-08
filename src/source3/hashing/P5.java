package source3.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class P5 {

    public String solution(String[] votes, int k) {
        HashMap<String, HashSet<String>> vote = new HashMap<>();
        HashMap<String, HashSet<String>> present = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        for (String str : votes) {
            String[] split = str.split(" ");
            String in = split[0];
            String out = split[1];

            countMap.put(out, countMap.getOrDefault(out, 0) + 1);

            HashSet<String> inDefault = vote.getOrDefault(in, new HashSet<>());
            inDefault.add(out);
            vote.put(in, inDefault);

            HashSet<String> outDefault = present.getOrDefault(out, new HashSet<>());
            outDefault.add(in);
            present.put(out, outDefault);
        }

        TreeMap<String, Integer> answerMap = new TreeMap<>();
        for (String key : countMap.keySet()) {
            if (countMap.get(key) >= k) {
                for (String p : present.get(key)) {
                    answerMap.put(p, answerMap.getOrDefault(p, 0) + 1);
                }
            }
        }

        int max = 0;
        String answer = null;

        for (String key : answerMap.keySet()) {
            if (answerMap.get(key) > max) {
                answer = key;
                max = answerMap.get(key);
            }
        }

        return answer;



    }

    public static void main(String[] args) {
        P5 T = new P5();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
