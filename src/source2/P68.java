package source2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new int[]{s, e});
        }

        list.sort((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        int answer = 0;

        for (int[] element : list) {
            int s = element[0];
            int e = element[1];

            while (!endTimePQ.isEmpty() && endTimePQ.peek() <= s) {
                endTimePQ.poll();
            }
            endTimePQ.offer(e);

            answer = Math.max(answer, endTimePQ.size());
        }

        System.out.println(answer);
    }
}
