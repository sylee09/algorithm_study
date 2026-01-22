package source1.ch05;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon12100 {
    static int N;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 이동
        func(arr, 0);
        System.out.println(answer);
    }

    static void func(int[][] arr, int num) {
        if (num == 5) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }
            if (max > answer) {
                answer = max;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            // 원래 arr는 갖는 array 만들기
            int[][] original = new int[N][N];
            for (int r = 0; r < N; r++) {
                System.arraycopy(arr[r], 0, original[r], 0, N);
            }
            // arr 이동
            moveFunc(arr, i);
            // backtracking
            func(arr, num + 1);
            // 원상복구
            for (int r = 0; r < N; r++) {
                System.arraycopy(original[r], 0, arr[r], 0, N);
            }
        }
    }

    static void moveFunc(int[][] arr, int dir) {
        switch(dir) {
            case 1:
                // 위쪽으로
                for (int j = 0; j < N; j++) {
                    LinkedList<Integer> queue = new LinkedList<>();
                    for (int i = 0; i < N; i++) {
                        if (arr[i][j] != 0) {
                            if (queue.isEmpty()) {
                                queue.offer(arr[i][j]);
                            } else {
                                if (queue.getLast() == arr[i][j]) {
                                    queue.pollLast();
                                    queue.offer(arr[i][j] + arr[i][j]);
                                    queue.offer(0);
                                } else {
                                    queue.offer(arr[i][j]);
                                }
                            }
                        }
                    }
                    int r = 0;
                    while (!queue.isEmpty()) {
                        int poll = queue.poll();
                        if (poll != 0) {
                            arr[r++][j] = poll;
                        }
                    }
                    while (r < N) {
                        arr[r++][j] = 0;
                    }
                }
                break;
            case 2:
                // 아래쪽으로
                for (int j = 0; j < N; j++) {
                    LinkedList<Integer> queue = new LinkedList<>();
                    for (int i = N-1; i >= 0; i--) {
                        if (arr[i][j] != 0) {
                            if (queue.isEmpty()) {
                                queue.offer(arr[i][j]);
                            } else {
                                if (queue.getLast() == arr[i][j]) {
                                    queue.pollLast();
                                    queue.offer(arr[i][j] + arr[i][j]);
                                    queue.offer(0);
                                } else {
                                    queue.offer(arr[i][j]);
                                }
                            }
                        }
                    }
                    int r = N - 1;
                    while (!queue.isEmpty()) {
                        int poll = queue.poll();
                        if (poll != 0) {
                            arr[r--][j] = poll;
                        }
                    }
                    while (r >= 0) {
                        arr[r--][j] = 0;
                    }
                }
                break;
            case 3:
                // 오른쪽으로
                for (int i = 0; i < N; i++) {
                    LinkedList<Integer> queue = new LinkedList<>();
                    for (int j = N - 1; j >= 0; j--) {
                        if (arr[i][j] != 0) {
                            if (queue.isEmpty()) {
                                queue.offer(arr[i][j]);
                            } else {
                                if (queue.getLast() == arr[i][j]) {
                                    queue.pollLast();
                                    queue.offer(arr[i][j] + arr[i][j]);
                                    queue.offer(0);
                                } else {
                                    queue.offer(arr[i][j]);
                                }
                            }
                        }
                    }
                    int c = N-1;
                    while (!queue.isEmpty()) {
                        int poll = queue.poll();
                        if (poll != 0) {
                            arr[i][c--] = poll;
                        }
                    }
                    while (c >= 0) {
                        arr[i][c--] = 0;
                    }
                }
                break;
            case 4:
                // 왼쪽으로
                for (int i = 0; i < N; i++) {
                    LinkedList<Integer> queue = new LinkedList<>();
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] != 0) {
                            if (queue.isEmpty()) {
                                queue.offer(arr[i][j]);
                            } else {
                                if (queue.getLast() == arr[i][j]) {
                                    queue.pollLast();
                                    queue.offer(arr[i][j] + arr[i][j]);
                                    queue.offer(0);
                                } else {
                                    queue.offer(arr[i][j]);
                                }
                            }
                        }
                    }
                    int c = 0;
                    while (!queue.isEmpty()) {
                        int poll = queue.poll();
                        if (poll != 0) {
                            arr[i][c++] = poll;
                        }
                    }
                    while (c < N) {
                        arr[i][c++] = 0;
                    }
                }
                break;
        }
    }
}
