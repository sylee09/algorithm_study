package source2;

import java.util.*;

public class P35 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>((a, b) -> -a.compareTo(b));

        dfs(arr, 0, 0, set, 0);

        int rank = 1;
        while (!set.isEmpty()) {
            Integer element = set.pollFirst();
            if (rank == K) {
                System.out.println(element);
                return;
            }
            rank++;
        }
        System.out.println(-1);
    }

    static void dfs(int[] arr, int level, int startIdx, TreeSet<Integer> set, int sum) {
        if (level == 3) {
            set.add(sum);
            return;
        }

        for (int i = startIdx; i < arr.length; i++) {
            dfs(arr, level + 1, i + 1, set, sum + arr[i]);
        }
    }
}
