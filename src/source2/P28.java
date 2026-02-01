package source2;

import java.util.Scanner;

public class P28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int firstIdx = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            while (sum > M) {
                sum -= arr[firstIdx++];
                if (sum == M) {
                    answer++;
                }
            }
            sum += arr[i];
            if (sum == M) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
