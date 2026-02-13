package source2;

import java.util.Arrays;
import java.util.Scanner;

public class P49 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] ordered = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            ordered[i] = arr[i];
        }

        Arrays.sort(ordered);

        for (int i = 0; i < N; i++) {
            if (arr[i] != ordered[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
