package ch05;

import java.util.*;

public class Baekjoon17822 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        LinkedList<Integer>[] circles = new LinkedList[N + 1];
        for (int i = 0; i <= N; i++) {
            circles[i] = new LinkedList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                circles[i].add(sc.nextInt());
            }
        }

        ArrayDeque<int[]> rotates = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();
            // x의 배수 원판 회전, d=0 => 시계 방향, d=1 => 반시계 방향, k = 회전 횟수
            rotates.add(new int[]{x, d, k});
        }

        // 원판 회전하기
        while (!rotates.isEmpty()) {
            int[] rotate = rotates.poll();
            int x = rotate[0];
            int d = rotate[1];
            int k = rotate[2];

            k %= M;
            for (int i = x; i <= N; i += x) {
                if (k == 0) {
                    continue;
                }
                if (d == 0) {
                    for (int c = 0; c < k; c++) {
                        int last = circles[i].pollLast();
                        circles[i].offerFirst(last);
                    }
                } else {
                    for (int c = 0; c < k; c++) {
                        int first = circles[i].poll();
                        circles[i].offer(first);
                    }
                }
            }

            // 인접 같은 수 찾기: "삭제 대상"을 모은다
            boolean[][] visited = new boolean[N + 1][M];
            boolean anyDeleted = false;
            HashSet<Coordinate> toDelete = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    int startVal = circles[i].get(j);
                    if(startVal==0||visited[i][j]) continue;

                    ArrayDeque<Coordinate> q = new ArrayDeque<>();
                    ArrayList<Coordinate> group = new ArrayList<>();

                    visited[i][j] = true;
                    q.offer(new Coordinate(i, j));
                    group.add(new Coordinate(i, j));

                    while (!q.isEmpty()) {
                        Coordinate cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if(nx<1||nx>N) continue;

                            // 좌우는 원형
                            if(ny<0) ny = M - 1;
                            else if(ny>=M) ny = 0;

                            if(visited[nx][ny]) continue;
                            if(circles[nx].get(ny)!=startVal) continue;

                            visited[nx][ny] = true;
                            q.offer(new Coordinate(nx, ny));
                            group.add(new Coordinate(nx, ny));
                        }
                    }

                    // 같은 숫자 그룹 크기 >=2면 삭제 대상
                    if (group.size() >= 2) {
                        anyDeleted = true;
                        toDelete.addAll(group);
                    }
                }
            }

            if (anyDeleted) {
                // 삭제
                for (Coordinate p : toDelete) {
                    circles[p.x].set(p.y, 0);
                }
            } else {
                // 평균 조정 (전체 평균 1번만)
                int sum = 0;
                int cnt = 0;
                for (int i = 1; i <= N; i++) {
                    for (int j = 0; j < M; j++) {
                        int v = circles[i].get(j);
                        if (v != 0) {
                            sum += v;
                            cnt++;
                        }
                    }
                }

                if (cnt == 0) {
                    break;
                }

                double avg = (double) sum / cnt;

                for (int i = 1; i <= N; i++) {
                    for (int j = 0; j < M; j++) {
                        int v = circles[i].get(j);
                        if (v == 0) {
                            continue;
                        }
                        if(v>avg) circles[i].set(j, v - 1);
                        else if(v<avg) circles[i].set(j, v + 1);
                    }
                }
            }
        }

        // 원판에 적힌 수의 합 구하기
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                sum += circles[i].get(j);
            }
        }

        System.out.println(sum);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
