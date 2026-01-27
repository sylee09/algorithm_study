package source2;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -a.compareTo(b));
        for (int element : arr) {
            pq.offer(element);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (!map.containsKey(poll)) {
                map.put(poll, rank);
            }
            rank++;
        }

        for (int element : arr) {
            System.out.print(map.get(element)+" ");
        }
    }
}
