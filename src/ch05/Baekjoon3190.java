package ch05;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon3190 {
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = 1;
        }
        int orders = sc.nextInt();
        sc.nextLine();

        //[시간, 방향]
        ArrayDeque<int[]> orderDir = new ArrayDeque<>();
        for (int i = 0; i < orders; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int t = Integer.parseInt(split[0]);
            String d = split[1];

            if (d.equals("D")) {
                orderDir.offer(new int[]{t, 1});
            } else if (d.equals("L")) {
                orderDir.offer(new int[]{t, -1});
            }
        }

        // 시뮬레이션 시작
        int curDir = 0;
        int curTime = 0;
        ArrayDeque<int[]> curPosition = new ArrayDeque<>();
        curPosition.offer(new int[]{1, 1});
        arr[1][1] = -1;
        while (true) {
            curTime++;
            int[] head = curPosition.getFirst();
            int[] nextD = dir[curDir];
            int nextR = head[0] + nextD[0];
            int nextC = head[1] + nextD[1];
            // 벽에 부딪히거나 자기몸에 부딪힘
            if (nextR == 0 || nextC == 0 || nextR > N || nextC > N || arr[nextR][nextC] == -1) {
                System.out.println(curTime);
                break;
            }
            // 사과를 먹지 않음
            if (arr[nextR][nextC] != 1) {
                int[] tail = curPosition.pollLast();
                arr[tail[0]][tail[1]] = 0;
            }
            curPosition.offerFirst(new int[]{nextR, nextC});
            arr[nextR][nextC] = -1;

            // orderDir에 있는 시간이 되면 방향 바꿈
            if (!orderDir.isEmpty() && orderDir.getFirst()[0] == curTime) {
                int[] poll = orderDir.poll();
                curDir = (curDir + poll[1] + 4) % 4;
            }
        }
    }
}
