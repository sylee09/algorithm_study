package source1.ch03;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon3197 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[R][C];

        // 백조 움직이는 위치 저장
        ArrayDeque<int[]> deque1 = new ArrayDeque<>();
        // 백조 다음번 움직이는 위치 저장
        ArrayDeque<int[]> deque2 = new ArrayDeque<>();
        // 물 움직이는 위치 저장
        ArrayDeque<int[]> water1 = new ArrayDeque<>();
        // 물 다음 움직이는 위치 저장
        ArrayDeque<int[]> water2 = new ArrayDeque<>();
        // 목표 백조 위치
        int[] target = new int[2];
        boolean[][] check = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == '.') {
                    water1.offer(new int[]{i, j});
                } else if (arr[i][j] == 'L') {
                    water1.offer(new int[]{i, j});
                    if (deque1.isEmpty()) {
                        deque1.offer(new int[]{i, j});
                        check[i][j] = true;
                    } else {
                        target[0] = i;
                        target[1] = j;
                    }
                }
            }
        }

        // 만약 백조가 다른 백조 만날수 있으면 종료
        // - 백조 bfs후 얼음 만나면 새로운 좌표에 넣기
        // - 그렇지 않으면 시간 + 1
        // - 얼음 녹이기

        int time = 0;
        while (true) {
            // 백조가 다른 백조 만날수 있는지 체크
            boolean flag = false;

            while (!deque1.isEmpty()) {
                int[] cur = deque1.poll();

                if (cur[0] == target[0] && cur[1] == target[1]) {
                    flag = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !check[nx][ny]) {
                        check[nx][ny] = true;

                        if (arr[nx][ny] == '.') {
                            deque1.offer(new int[]{nx, ny});
                        } else if (arr[nx][ny] == 'L') {
                            flag = true;
                            break;
                        } else {
                            deque2.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            if (flag) {
                System.out.println(time);
                return;
            }

            // 백조 시작위치 재조정
            while (!deque2.isEmpty()) {
                deque1.offer(deque2.poll());
            }

            // 시간 증가
            time++;

            // 얼음 녹이기
            while (!water1.isEmpty()) {
                int[] cur = water1.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (arr[nx][ny] == 'X') {
                            water2.offer(new int[]{nx, ny});
                            arr[nx][ny] = '.';
                        }
                    }
                }
            }

            // 얼음 시작 위치 재조정
            while (!water2.isEmpty()) {
                water1.offer(water2.poll());
            }
        }

    }
}
