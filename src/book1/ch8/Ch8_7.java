package book1.ch8;

import java.util.*;

public class Ch8_7 {

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();

        for (int c : course) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String ord : orders) {
                ArrayList<Character> list = new ArrayList<>();
                for (char ch : ord.toCharArray()) {
                    list.add(ch);
                }
                list.sort((a, b) -> a.compareTo(b));
                helper(new StringBuilder(), map, c, 0, list);
            }
            TreeMap<Integer, ArrayList<String>> reverseMap = new TreeMap<>((a, b) -> b - a);

            for (String key : map.keySet()) {
                ArrayList<String> orDefault = reverseMap.getOrDefault(map.get(key), new ArrayList<>());
                orDefault.add(key);
                reverseMap.put(map.get(key), orDefault);
            }

            if (!reverseMap.isEmpty()) {
                Map.Entry<Integer, ArrayList<String>> entry = reverseMap.pollFirstEntry();
                if (entry.getKey() > 1) {
                    answerList.addAll(entry.getValue());
                }
            }
        }
        answerList.sort((a, b) -> a.compareTo(b));
        return answerList.toArray(new String[0]);
    }

    public void helper(StringBuilder sb, HashMap<String, Integer> map, int c, int start, ArrayList<Character> ord) {
        if (sb.length() == c) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int idx = start; idx < ord.size(); idx++) {
            sb.append(ord.get(idx));
            helper(sb, map, c, idx + 1, ord);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Ch8_7 solution = new Ch8_7();
        String[] solution1 = solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println(Arrays.toString(solution1));

        String[] solution2 = solution.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        System.out.println(Arrays.toString(solution2));

        String[] solution3 = solution.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
        System.out.println(Arrays.toString(solution3));
    }
}
