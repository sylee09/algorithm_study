package ch03;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon17071 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        // [좌표,홀/짝]
        boolean[][] check = new boolean[500001][2];

        // 만약 N과 K가 같으면 이미 만난것
        if (N == K) {
            System.out.println(0);
            return;
        }

        // bfs로 check를 채운다. 만약 홀/짝에서 좌표가 true면 최소시간으로 동생을 찾은것
        // [좌표, 시간]
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{N, 0});
        check[N][0] = true;
        int t = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] cur = deque.poll();
                int curX = cur[0];
                int curT = cur[1];
                int isEvenOrOdd = curT % 2;

                if (check[K][isEvenOrOdd]) {
                    System.out.println(t);
                    return;
                }

                int[] next = new int[]{curX + 1, curX - 1, curX * 2};
                for (int n : next) {
                    if (n < 0 || n > 500_000) {
                        continue;
                    }
                    if (!check[n][(curT + 1) % 2]) {
                        check[n][(curT + 1) % 2] = true;
                        deque.offer(new int[]{n, curT + 1});
                    }
                }
            }
            t++;
            K += t;

            if (K > 500_000) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(-1);
    }
}
