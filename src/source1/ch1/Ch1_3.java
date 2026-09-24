package source1.ch1;

import java.util.*;

public class Ch1_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();

        for (int i = 1; i <= 3; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");

            in.offer(Integer.parseInt(split[0]));
            out.offer(Integer.parseInt(split[1]));
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, A);
        map.put(2, B);
        map.put(3, C);

        in.sort((a, b) -> a - b);
        out.sort((a, b) -> a - b);

        int answer = 0;
        int curBuses = 0;
        int lastTime = 0;

        for (int cur = 0; cur <= 100; cur++) {
            if (in.isEmpty() && out.isEmpty()) {
                break;
            }
            if ((!in.isEmpty() && cur == in.peek()) || (!out.isEmpty() && cur == out.peek())) {
                answer += (curBuses * map.get(curBuses) * (cur - lastTime));
                while (!in.isEmpty() && cur == in.peek()) {
                    curBuses++;
                    in.poll();
                }
                while (!out.isEmpty() && cur == out.peek()) {
                    curBuses--;
                    out.poll();
                }
                lastTime = cur;
            }
        }

        System.out.println(answer);
    }
}
