package ch05;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon1700 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> multitab = new LinkedList<>();
        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        // 멀티탭에 플러그 꽂기
        for (int i = 0; i < K; i++) {
            // 만약 이미 꽂혀있는 기기라면 continue
            if (multitab.contains(arr[i])) {
                continue;
            }
            // 만약 멀티탭에 구멍이 남아있다면 꽂기
            if (multitab.size() < N) {
                multitab.add(arr[i]);
            } else {
                // 만약 멀티탭에 구멍이 더이상 없다면
                // PQ에 현재 꽂혀있는 플러그가 언제 다시 나오는지를 기준으로 내림차순 정렬
                // <[전기용품 이름, 다시 나오는 index]>
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                    if (a[1] > b[1]) {
                        return -1;
                    } else if (a[1] < b[1]) {
                        return 1;
                    }
                    return 0;
                });

                // 현재 꽂혀있는 기기가 언제 나오는지를 기준으로 pq에 넣는다. (내림차순)
                for (int x = 0; x < multitab.size(); x++) {
                    int key = multitab.get(x);
                    int val = Integer.MAX_VALUE;

                    for (int j = i + 1; j < K; j++) {
                        if (arr[j] == key) {
                            val = j;
                            break;
                        }
                    }
                    pq.offer(new int[]{key, val});
                }

                // multitab에 pq에서 poll된 것을 제거 (순서상 가장 늦게 꽂아야함)
                int[] remove = pq.poll();
                multitab.remove((Integer) remove[0]);
                answer++;
                multitab.add(arr[i]);
            }
        }
        System.out.println(answer);
    }
}
