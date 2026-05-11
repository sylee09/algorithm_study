package book1.ch8;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Ch8_6 {

    public int[] solution(String[] id_list, String[] report, int k) {
        LinkedHashMap<String, HashSet<String>> reportMap = new LinkedHashMap<>();

        HashMap<String, Integer> reportCountMap = new HashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] split = r.split(" ");
            String p1 = split[0];
            String p2 = split[1];

            HashSet<String> reportList = reportMap.get(p1);
            reportList.add(p2);
        }

        for (HashSet<String> val : reportMap.values()) {
            for (String p : val) {
                reportCountMap.put(p, reportCountMap.getOrDefault(p, 0) + 1);
            }
        }

        HashSet<String> banned = new HashSet<>();

        for (String key : reportCountMap.keySet()) {
            Integer i = reportCountMap.get(key);
            if (i >= k) {
                banned.add(key);
            }
        }

        int[] answer = new int[id_list.length];
        int idx = 0;
        for (String key : reportMap.keySet()) {
            HashSet<String> strings = reportMap.get(key);
            for (String str : strings) {
                if (banned.contains(str)) {
                    answer[idx]++;
                }
            }
            idx++;
        }
        return answer;
    }
}
