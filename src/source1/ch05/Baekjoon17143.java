package source1.ch05;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon17143 {
    // 위, 아래, 오른쪽, 왼쪽
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<Shark> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt() - 1;
            int z = sc.nextInt();

            Shark shark = new Shark(r, c, s, d, z);
            pq.offer(shark);
        }

        // 시뮬레이션 시작
        int cur = 0;
        int answer = 0;
        while (true) {
            Shark[][] arr = new Shark[R + 1][C + 1];
            // 오른쪽 한 칸 이동
            cur += 1;
            if (cur > C) {
                break;
            }
            // 땅과 제일 가까운 상어 잡는다
            PriorityQueue<Shark> newPq = new PriorityQueue<>();
            while (!pq.isEmpty()) {
                Shark poll = pq.poll();
                if (poll.c == cur) {
                    answer += poll.z;
                    break;
                }
                newPq.offer(poll);
            }

            while (!newPq.isEmpty()) {
                pq.offer(newPq.poll());
            }

            // 상어 이동
            while (!pq.isEmpty()) {
                Shark poll = pq.poll();
                int dir = poll.d;
                int mv1 = poll.s % (2 * (R - 1));
                int mv2 = poll.s % (2 * (C - 1));

                if (dir == 0 || dir == 1) {
                    for (int i = 0; i < mv1; i++) {
                        int nx = poll.r + dx[dir];
                        if (nx < 1 || nx > R) {
                            dir = dir == 0 ? 1 : 0;
                            nx = poll.r + dx[dir];
                        }
                        poll.r = nx;
                    }
                    poll.d = dir;
                }

                if (dir == 2 || dir == 3) {
                    for (int i = 0; i < mv2; i++) {
                        int ny = poll.c + dy[dir];
                        if (ny < 1 || ny > C) {
                            dir = dir == 2 ? 3 : 2;
                            ny = poll.c + dy[dir];
                        }
                        poll.c = ny;
                    }
                    poll.d = dir;
                }
                newPq.offer(poll);
            }
            // 크기가 큰 상어가 작은 상어 잡아먹는다.
            ArrayDeque<Shark> deque = new ArrayDeque<>();
            while (!newPq.isEmpty()) {
                Shark poll = newPq.poll();
                if (arr[poll.r][poll.c] != null) {
                    deque.pollLast();
                }
                deque.offer(poll);
                arr[poll.r][poll.c] = poll;
            }
            pq.addAll(deque);
        }

        System.out.println(answer);
    }

    static class Shark implements Comparable<Shark>{
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.c < o.c) {
                return -1;
            } else if (this.c > o.c) {
                return 1;
            } else if (this.r < o.r) {
                return -1;
            } else if (this.r > o.r) {
                return 1;
            } else if (this.z < o.z) {
                return -1;
            } else if (this.z > o.z) {
                return 1;
            }
            return 0;
        }
    }
}
