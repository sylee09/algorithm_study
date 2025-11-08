package ch03;

import java.util.*;

public class Baekjoon16234 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 만약 조건 만족안하면 루프 종료
        int ans = 0;
        while (true) {
            boolean flag = false;
            // 인구차가 L이상 R이하면 연합
            // <alignNum, 연합한 area 좌표들>
            HashMap<Integer, ArrayList<int[]>> aligns = new HashMap<>();
            boolean[][] check = new boolean[N][N];
            int alignNum = 0;

            // 각 영역에서 bfs해서 연합들을 구함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (check[i][j]) {
                        continue;
                    }
                    // bfs
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    aligns.put(alignNum, list);
                    ArrayDeque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{i, j});
                    check[i][j] = true;
                    while (!deque.isEmpty()) {
                        int[] cur = deque.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!check[nx][ny]) {
                                    int dist = Math.abs(arr[nx][ny] - arr[cur[0]][cur[1]]);
                                    if (dist >= L && dist <= R) {
                                        check[nx][ny] = true;
                                        list.add(new int[]{nx, ny});
                                        deque.offer(new int[]{nx, ny});
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                    alignNum++;
                }
            }

            // 만약 flag = false 면 연합 없음
            if (!flag) {
                break;
            }

            for (Map.Entry<Integer, ArrayList<int[]>> entry : aligns.entrySet()) {
                int totalArea = 0;
                int numArea = entry.getValue().size();
                for (int[] areaPos : entry.getValue()) {
                    totalArea += arr[areaPos[0]][areaPos[1]];
                }
                totalArea = totalArea / numArea;
                for (int[] areaPos : entry.getValue()) {
                    arr[areaPos[0]][areaPos[1]] = totalArea;
                }
            }
            ans++;
        }

        System.out.println(ans);
    }
}
