package source2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P33 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int idx = 0; idx < K; idx++) {
            map.put(arr[idx], map.getOrDefault(arr[idx], 0) + 1);
        }

        answer.add(map.size());

        for (int idx = K; idx < N; idx++) {
            map.put(arr[idx - K], map.get(arr[idx - K]) - 1);
            if (map.get(arr[idx - K]) == 0) {
                map.remove(arr[idx - K]);
            }
            map.put(arr[idx], map.getOrDefault(arr[idx], 0) + 1);
            answer.add(map.size());
        }

        for (int element : answer) {
            System.out.print(element+" ");
        }
    }
}
