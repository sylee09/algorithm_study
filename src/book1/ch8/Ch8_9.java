package book1.ch8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ch8_9 {

    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (int a = 'A'; a <= 'Z'; a++) {
            map.put(String.valueOf((char) a), idx);
            idx++;
        }
        ArrayList<Integer> answerList = new ArrayList<>();

        int cur = 0;
        int val = 27;
        StringBuilder sb = new StringBuilder();

        while (cur < msg.length()) {
            sb.append(msg.charAt(cur));
            if (map.containsKey(sb.toString())) {
                if (!answerList.isEmpty()) {
                    answerList.remove(answerList.size() - 1);
                }
                answerList.add(map.get(sb.toString()));
            } else {
                map.put(sb.toString(), val++);
                sb = new StringBuilder();
                sb.append(msg.charAt(cur));
                answerList.add(map.get(sb.toString()));
            }
            cur++;
        }
        return answerList.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static void main(String[] args) {
        Ch8_9 solution = new Ch8_9();
        System.out.println(Arrays.toString(solution.solution("KAKAO")));
        System.out.println(Arrays.toString(solution.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution.solution("ABABABABABABABAB")));
    }
}
