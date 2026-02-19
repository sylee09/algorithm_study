package source2;

import java.util.Arrays;
import java.util.Scanner;

public class P51 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);


        // 이진탐색
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == M) {
                System.out.println(mid + 1);
                return;
            }
            if (arr[mid] > M) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }
}
