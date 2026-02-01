package source2;

import java.util.Scanner;

public class P29 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N - 1];

        for (int i = 1; i < N; i++) {
            arr[i - 1] = i;
        }

        int sum = 0;
        int answer = 0;
        int firstIdx = 0;

        for (int idx = 0; idx < N-1; idx++) {
            sum += arr[idx];
            if (sum == N) {
                answer++;
            }
            while (sum > N) {
                sum -= arr[firstIdx++];
                if (sum == N) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
