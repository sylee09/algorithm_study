package ch04;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon14890 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        // 행 가능 개수 찾기
        for (int i = 0; i < N; i++) {
            int cur = 0;
            boolean flag = true;
            // 다리 지은곳 저장
            HashSet<Integer> set = new HashSet<>();

            while (cur < N) {
                int next = cur + 1;
                int curH = arr[i][cur];

                // 만약 현재 높이와 다음 높이 길이 차이가 1보다 크면 불가능
                if (next < N && Math.abs(curH - arr[i][next]) > 1) {
                    flag = false;
                    break;
                }
                // 만약 현재 높이가 더 크고 다음 높이가 같은거 수가 L보다 작으면 불가능
                int cnt = 0;
                if (next < N && curH > arr[i][next]) {
                    int nextNext = next;
                    while (nextNext < N && arr[i][next] == arr[i][nextNext] && cnt < L) {
                        if (set.contains(nextNext)) {
                            flag = false;
                            break;
                        }
                        set.add(nextNext);
                        cnt++;
                        nextNext = nextNext + 1;
                    }
                    if (cnt < L) {
                        flag = false;
                        break;
                    }
                    for (int a = 0; a < cnt; a++) {
                        cur = cur + 1;
                    }
                }
                // 만약 다음 높이가 더 크고 현재 높이가 같은거 수가 L보다 작으면 불가능
                else if (next < N && curH < arr[i][next]) {
                    int prev = cur;
                    while (prev >= 0 && arr[i][prev] == arr[i][cur] && cnt < L) {
                        if (set.contains(prev)) {
                            flag = false;
                            break;
                        }
                        set.add(prev);
                        cnt++;
                        prev = prev - 1;
                    }
                    if (cnt < L) {
                        flag = false;
                        break;
                    }
                    cur++;
                } else {
                    cur++;
                }
            }
            if (flag) {
                answer++;
            }
        }

        // 열 가능 개수 찾기
        for (int j = 0; j < N; j++) {
            int cur = 0;
            boolean flag = true;
            // 다리 지은곳 저장
            HashSet<Integer> set = new HashSet<>();

            while (cur < N) {
                int next = cur + 1;
                int curH = arr[cur][j];

                // 만약 현재 높이와 다음 높이 길이 차이가 1보다 크면 불가능
                if (next < N && Math.abs(curH - arr[next][j]) > 1) {
                    flag = false;
                    break;
                }
                // 만약 현재 높이가 더 크고 다음 높이가 같은거 수가 L보다 작으면 불가능
                int cnt = 0;
                if (next < N && curH > arr[next][j]) {
                    int nextNext = next;
                    while (nextNext < N && arr[next][j] == arr[nextNext][j] && cnt < L) {
                        if (set.contains(nextNext)) {
                            flag = false;
                            break;
                        }
                        set.add(nextNext);
                        cnt++;
                        nextNext = nextNext + 1;
                    }
                    if (cnt < L) {
                        flag = false;
                        break;
                    }
                    for (int a = 0; a < cnt; a++) {
                        cur = cur + 1;
                    }
                }
                // 만약 다음 높이가 더 크고 현재 높이가 같은거 수가 L보다 작으면 불가능
                else if (next < N && curH < arr[next][j]) {
                    int prev = cur;
                    while (prev >= 0 && arr[prev][j] == arr[cur][j] && cnt < L) {
                        if (set.contains(prev)) {
                            flag = false;
                            break;
                        }
                        set.add(prev);
                        cnt++;
                        prev = prev - 1;
                    }
                    if (cnt < L) {
                        flag = false;
                        break;
                    }
                    cur++;
                } else {
                    cur++;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
