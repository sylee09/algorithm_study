package ch03;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon2589 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 만약 arr[i][j]가 L이면 bfs. bfs의 최대 거리가 정답 후보
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    boolean[][] check = new boolean[N][M];
                    check[i][j] = true;
                    ArrayDeque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{i, j});
                    int level = 0;

                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        for (int a = 0; a < size; a++) {
                            int[] cur = deque.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                    if (!check[nx][ny] && arr[nx][ny] == 'L') {
                                        check[nx][ny] = true;
                                        deque.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                        level++;
                    }
                    answer = Math.max(answer, level-1);
                }
            }
        }
        System.out.println(answer);
    }
}
