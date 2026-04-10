package source3.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class P7 {

    public String[] solution(String[] reports, int time){
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            return a.compareTo(b);
        });

        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> timeMap = new HashMap<>();

        for (String rp : reports) {
            String[] split = rp.split(" ");
            String name = split[0];
            String stringTime = split[1];
            String[] stringTimeSplit = stringTime.split(":");

            int h = Integer.parseInt(stringTimeSplit[0]);
            int m = Integer.parseInt(stringTimeSplit[1]);

            int t = 60 * h + m;

            if (!inMap.containsKey(name)) {
                inMap.put(name, t);
            } else {
                Integer t1 = inMap.get(name);
                inMap.remove(name);
                timeMap.put(name, timeMap.getOrDefault(name, 0) + (t - t1));
            }
        }

        for (String key : timeMap.keySet()) {
            if (timeMap.get(key) > time) {
                pq.offer(key);
            }
        }

        ArrayList<String> answerList = new ArrayList<>();

        while (!pq.isEmpty()) {
            String poll = pq.poll();
            answerList.add(poll);
        }

        return answerList.stream().toArray(String[]::new);
    }

    public static void main(String[] args){
        P7 T = new P7();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
