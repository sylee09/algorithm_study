package source2;

import java.util.Scanner;

public class P52 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        int l = 1;
        int r = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            r += arr[i];
        }
        r += 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (canDo(arr, mid, M)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    static boolean canDo(int[] arr, int mid, int M) {
        int sum = 0;
        int val = 1;

        for (int element : arr) {
            if (sum + element <= mid) {
                sum += element;
            } else {
                val++;
                sum = element;
            }
        }
        return val <= M;
    }
}
