package source2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 시간별 정렬
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int D = sc.nextInt();

            list.add(new int[]{M, D});
        }

        list.sort((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] element : list) {
            int M = element[0];
            int D = element[1];

            while (minHeap.size() >= D) {
                minHeap.poll();
            }
            minHeap.add(M);
        }

        int answer = 0;

        while (!minHeap.isEmpty()) {
            answer += minHeap.poll();
        }

        System.out.println(answer);
    }
}
