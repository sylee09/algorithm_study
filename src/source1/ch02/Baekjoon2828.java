package source1.ch02;

import java.util.Scanner;

public class Baekjoon2828 {

    public static void main(String[] args) {
        //입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] bucket = new int[]{1, 1 + M - 1};

        int J = sc.nextInt();
        int[] apples = new int[J];
        for (int i = 0; i < J; i++) {
            apples[i] = sc.nextInt();
        }

        int answer = 0;
        for (int apple : apples) {
            // 바구니 이동 거리 (가장 외곽에서 이동한 만큼)
            int dist = Math.min(Math.abs(bucket[0] - apple), Math.abs(bucket[1] - apple));
            // 바구니안에 사과가 들어가는 경우 이동거리 = 0
            if (apple >= bucket[0] && apple <= bucket[1]) {
                dist = 0;
            }
            if (bucket[1] < apple) {
                bucket[0] = bucket[0] + dist;
                bucket[1] = bucket[1] + dist;
            } else {
                bucket[0] -= dist;
                bucket[1] -= dist;
            }
            answer += dist;
        }
        System.out.println(answer);
    }
}
