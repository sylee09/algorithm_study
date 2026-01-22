package source1.ch02;

import java.util.Scanner;

public class Baekjoon3474 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            int ans = 0;
            int idx = 1;
            // 2*5가 있어야 뒤에 0이 붙는데 Min(2의개수, 5의개수)는 항상 5의개수이므로 5의 개수를 센다.
            while (Math.pow(5, idx) <= N) {
                int num = (int) Math.pow(5, idx);
                ans += (N / num);
                idx++;
            }
            System.out.println(ans);
        }
    }
}
