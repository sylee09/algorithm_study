package source2;

import java.util.*;

public class P71 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int i = 1; i <= E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();

            ArrayList<int[]> list1 = graph.getOrDefault(start, new ArrayList<>());
            ArrayList<int[]> list2 = graph.getOrDefault(end, new ArrayList<>());
            list1.add(new int[]{end, weight});
            list2.add(new int[]{start, weight});
            graph.put(start, list1);
            graph.put(end, list2);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });


        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        int answer = 0;

        for (int[] val : graph.get(1)) {
            pq.offer(val);
        }

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            if (set.contains(polled[0])) {
                continue;
            }
            int cur = polled[0];
            int weight = polled[1];

            answer += weight;
            set.add(cur);

            for (int[] val : graph.get(cur)) {
                pq.offer(val);
            }
        }

        System.out.println(answer);
    }
}
