package source2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P24 {

    public static void main(String[] args) {
        HashMap<Integer, HashSet<Integer>> mentorMentee = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= M; i++) {
            mentorMentee.put(i, new HashSet<>());
            for (int x = 1; x <= M; x++) {
                if(i!=x){ mentorMentee.get(i).add(x);}
            }
        }

        for (int[] x : arr) {
            HashSet<Integer> set = new HashSet<>();
            for (int idx = 0; idx < M; idx++) {
                set.add(x[idx]);
                for (int key : mentorMentee.keySet()) {
                    if (set.contains(key)) {
                        continue;
                    }
                    mentorMentee.get(key).remove(x[idx]);
                }
            }
        }

        int answer = 0;

        for (HashSet<Integer> set : mentorMentee.values()) {
//            System.out.println(set);
            if (!set.isEmpty()) {
                answer += set.size();
            }
        }

        System.out.println(answer);
    }
}
