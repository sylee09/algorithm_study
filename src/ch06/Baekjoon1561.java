package ch06;


import java.util.Scanner;

public class Baekjoon1561 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        long[] arr = new long[(int) M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextLong();
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }

        // 모든 아이들이 타는 시간 구하기
        long l = 1;
        long r = 30 * N + 1;

        // lowerbound
        while (l < r) {
            long mid = (l + r) / 2;
            long totalPeople = M;
            for (long element : arr) {
                totalPeople += (mid / element);
            }
            if (totalPeople >= N) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }


        // 최소 시간 -1 시간에서 몇명이 타는지 계산
        long totalPeople = M;
        long time = l - 1;
        for (long element : arr) {
            totalPeople += (time / element);
        }

        // totalPeople == N일때 놀이기구 번호 출력후 종료
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < arr.length; i++) {
                if (l % arr[i] == 0) {
                    totalPeople++;
                }
                if (totalPeople == N) {
                    System.out.println(i+1);
                    flag = true;
                    break;
                }
            }
        }
    }
}
