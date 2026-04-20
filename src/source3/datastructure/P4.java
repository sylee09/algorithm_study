package source3.datastructure;


import java.util.ArrayDeque;

public class P4 {
    public int solution(int[] laser, String[] enter) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int answer = 0;

        for (String str : enter) {
            String[] split = str.split(" ");
            String time = split[0];
            String option = split[1];
            int enterTime = getTimeOfMin(time);
            int exitTime = enterTime + laser[Integer.parseInt(option)];

            // queue가 비어있을때 queue에 나가는 시간 집어넣는다.
            if (queue.isEmpty()) {
                queue.offer(exitTime);
            } else {
                while (!queue.isEmpty() && queue.peek() <= enterTime) {
                    queue.poll();
                }
                if (queue.isEmpty()) {
                    queue.offer(exitTime);
                }else {
                    queue.offer(queue.peekLast() + laser[Integer.parseInt(option)]);
                }
            }
            answer = Math.max(answer, queue.size());
        }

        return answer - 1;
    }


    private int getTimeOfMin(String time) {
        String[] times = time.split(":");
        int h = Integer.parseInt(times[0]);
        int m = Integer.parseInt(times[1]);
        return h * 60 + m;
    }

    public static void main(String[] args) {
        P4 T = new P4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
