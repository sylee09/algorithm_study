package book1;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Ch5_6 {

    public int[] solution(int N, int[] stages) {
        int[] numPeopleInStages = new int[N + 2];
        int totalPeople = stages.length;

        for (int num : stages) {
            numPeopleInStages[num]++;
        }


        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->{
            if (a[1] < b[1]) {
                return 1;
            } else if (a[1] > b[1]) {
                return -1;
            } else if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        int[] sorted = Arrays.stream(stages).sorted().filter(x -> x != N + 1).toArray();

        HashSet<Integer> set = new HashSet<>();
        for (int s : sorted) {
            if (!set.contains(s)) {
                set.add(s);
                double fraction = (double) numPeopleInStages[s] / totalPeople;
                totalPeople -= numPeopleInStages[s];
                pq.offer(new double[]{s, fraction});
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                pq.offer(new double[]{i, 0});
            }
        }


        int[] answer = new int[N];

        int idx = 0;
        while (!pq.isEmpty()) {
            double[] poll = pq.poll();
            answer[idx++] = (int) poll[0];
        }
        return answer;
    }

    public static void main(String[] args) {
        Ch5_6 solution = new Ch5_6();
        System.out.println(Arrays.toString(solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution.solution(4, new int[]{4, 4, 4, 4, 4})));
    }
}
