package source1.ch03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon14497 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int x1 = sc.nextInt() - 1;
        int y1 = sc.nextInt() - 1;
        int x2 = sc.nextInt() - 1;
        int y2 = sc.nextInt() - 1;
        char[][] arr = new char[N][M];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int time = 0;
        boolean[][] check = new boolean[N][M];
        LinkedList<int[]> list = new LinkedList<>();
        list.offer(new int[]{x1, y1});
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        check[x1][y1] = true;

        // bfs로 점프 뜀 표현
        // #에 파동이 전달될때까지 반복
        while (true) {
            // list에 있는것 queue에 넣는다.
            while (!list.isEmpty()) {
                queue.offer(list.poll());
            }
            time++;
            // bfs 수행
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];

                if (curX == x2 && curY == y2) {
                    System.out.println(time);
                    return;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = curX + dx[k];
                    int ny = curY + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        if (arr[nx][ny] == '0' || arr[nx][ny] == '#') {
                            queue.offer(new int[]{nx, ny});
                        }
                        // 파동 전파 종료 및 장애물 제거
                        else if (arr[nx][ny] == '1') {
                            list.offer(new int[]{nx, ny});
                            arr[nx][ny] = '0';
                        }
                    }
                }
            }
//            System.out.println("*******************");
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(arr[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println("*******************");

        }

    }
}
