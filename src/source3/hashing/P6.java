package source3.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P6 {

    public String[] solution(String[] reports, String times){
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            String time1 = a[1];
            String time2 = b[1];

            String[] split1 = time1.split(":");
            int h1 = Integer.parseInt(split1[0]);
            int m1 = Integer.parseInt(split1[1]);

            String[] split2 = time2.split(":");
            int h2 = Integer.parseInt(split2[0]);
            int m2 = Integer.parseInt(split2[1]);

            int t1 = h1 * 60 + m1;
            int t2 = h2 * 60 + m2;

            if (t1 < t2) {
                return -1;
            } else if (t1 > t2) {
                return 1;
            } else {
                return 0;
            }
        });

        String[] splitTimes = times.split(" ");
        String startTime = splitTimes[0];
        String endTime = splitTimes[1];

        for (String r : reports) {
            String[] split = r.split(" ");
            String name = split[0];
            String time = split[1];

            if (isBetween(time, startTime, endTime)) {
                pq.offer(new String[]{name, time});
            }
        }

        ArrayList<String> answerList = new ArrayList<>();
        while (!pq.isEmpty()) {
            answerList.add(pq.poll()[0]);
        }

        return answerList.stream().map((s) -> String.valueOf(s)).toArray(String[]::new);
    }
    
    public boolean isBetween(String time, String startTime, String endTime) {
        String[] split1 = time.split(":");
        int h1 = Integer.parseInt(split1[0]);
        int m1 = Integer.parseInt(split1[1]);
        int t1 = h1 * 60 + m1;

        String[] split2 = startTime.split(":");
        int h2 = Integer.parseInt(split2[0]);
        int m2 = Integer.parseInt(split2[1]);
        int t2 = h2 * 60 + m2;

        String[] split3 = endTime.split(":");
        int h3 = Integer.parseInt(split3[0]);
        int m3 = Integer.parseInt(split3[1]);
        int t3 = h3 * 60 + m3;

        if (t2 <= t1 && t1 <= t3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
