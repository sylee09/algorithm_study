package source2;

import java.util.Scanner;
public class P23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][5];
        int maxCnt = 0;
        int answer = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                for (int idx = 0; idx < 5; idx++) {
                    if (arr[i][idx] == arr[j][idx]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
