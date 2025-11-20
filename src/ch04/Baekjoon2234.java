package ch04;

import java.util.*;

public class Baekjoon2234 {
    // 방 번호 저장
    static int roomNum = 1;
    // 방별 번호 저장
    static int[][] rooms;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] arr = new int[N][M];
        rooms = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 1. 성에 있는 방의 개수 구하기
        boolean[][] check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j]) {
                    ArrayDeque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{i, j});
                    check[i][j] = true;
                    rooms[i][j] = roomNum;

                    while (!deque.isEmpty()) {
                        int[] cur = deque.poll();
                        int curX = cur[0];
                        int curY = cur[1];

                        for (int k = 0; k < 4; k++) {
                            if (k == 0 && (arr[curX][curY] & 2) != 0) {
                                continue;
                            }
                            if (k == 1 && (arr[curX][curY] & 4) != 0) {
                                continue;
                            }
                            if (k == 2 && (arr[curX][curY] & 8) != 0) {
                                continue;
                            }
                            if (k == 3 && (arr[curX][curY] & 1) != 0) {
                                continue;
                            }
                            int nx = dx[k] + cur[0];
                            int ny = dy[k] + cur[1];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                if (!check[nx][ny]) {
                                    check[nx][ny] = true;
                                    rooms[nx][ny] = roomNum;
                                    deque.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    roomNum++;
                }
            }
        }
        System.out.println(roomNum - 1);
        // 2. 가장 넓은 방의 넓이 구하기
        int maxArea = 0;
        HashMap<Integer, Integer> areaMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                areaMap.put(rooms[i][j], areaMap.getOrDefault(rooms[i][j], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : areaMap.entrySet()) {
            if (entry.getValue() > maxArea) {
                maxArea = entry.getValue();
            }
        }
        System.out.println(maxArea);
        // 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기 구하기
        int thirdAnswer = 0;
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!check[i][j]) {
                    int curRoomNum = rooms[i][j];
                    ArrayDeque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{i, j});
                    check[i][j] = true;
                    thirdAnswer = Math.max(thirdAnswer, areaMap.get(curRoomNum));

                    while (!deque.isEmpty()) {
                        int[] cur = deque.poll();
                        int curX = cur[0];
                        int curY = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = curX + dx[k];
                            int ny = curY + dy[k];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !check[nx][ny]) {
                                if (rooms[nx][ny] == curRoomNum) {
                                    check[nx][ny] = true;
                                    deque.offer(new int[]{nx, ny});
                                } else {
                                    thirdAnswer = Math.max(thirdAnswer, areaMap.get(curRoomNum) + areaMap.get(rooms[nx][ny]));
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(thirdAnswer);
    }
}
