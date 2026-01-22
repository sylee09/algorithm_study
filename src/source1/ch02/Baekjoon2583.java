package source1.ch02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon2583 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        boolean[][] area = new boolean[N][M];

        // x=행, y=열
        for (int k = 1; k <= K; k++) {
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();

            for (int x = x1; x <= x2 - 1; x++) {
                for (int y = y1; y <= y2 - 1; y++) {
                    area[x][y] = true;
                }
            }
        }

        int numArea = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!area[x][y]) {
                    bfs(area, x, y, list);
                    numArea++;
                }
            }
        }

        System.out.println(numArea);
        list.sort((a,b)->{
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        });
        for (int element : list) {
            System.out.print(element+" ");
        }
    }

    static void bfs(boolean[][] area, int x, int y, ArrayList<Integer> list) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{x, y});
        area[x][y] = true;
        int size = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            size++;

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur[0];
                int ny = dy[k] + cur[1];

                if (nx >= 0 && nx < area.length && ny >= 0 && ny < area[0].length) {
                    if (!area[nx][ny]) {
                        deque.offer(new int[]{nx, ny});
                        area[nx][ny] = true;
                    }
                }
            }
        }
        list.add(size);
    }
}
