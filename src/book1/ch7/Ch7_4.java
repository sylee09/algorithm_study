package book1.ch7;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ch7_4 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        Queue<Integer> trucks = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        for (int t : truck_weights) {
            trucks.offer(t);
        }

        int time = 0;

        while (!bridge.isEmpty()) {
            time++;
            bridge.poll();
            int sum = bridge.stream().mapToInt(x -> x.intValue()).sum();
            if (!trucks.isEmpty() && sum + trucks.peek() <= weight) {
                bridge.offer(trucks.poll());
            } else if(!trucks.isEmpty()){
                bridge.offer(0);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Ch7_4 solution = new Ch7_4();
        System.out.println(solution.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution.solution(100, 100, new int[]{10}));
        System.out.println(solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));

    }
}
