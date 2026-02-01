package source2;

import java.util.Scanner;

public class P30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int count = 0;
        int firstIdx = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                count++;
                answer = Math.max(answer, count);
                continue;
            }
            if (K > 0) {
                K--;
                count++;
                answer = Math.max(answer, count);
            } else {
                while (arr[firstIdx] != 0) {
                    count--;
                    firstIdx++;
                }
                firstIdx++;
            }
        }

        System.out.println(answer);
    }
}
