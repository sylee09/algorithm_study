package source2;

import java.util.Scanner;

public class P44 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int cur = 0; cur < N; cur++) {
            int min = arr[cur];
            int minIndex = cur;
            for (int i = cur + 1; i < N; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            int temp = arr[cur];
            arr[cur] = min;
            arr[minIndex] = temp;
        }

        for (int element : arr) {
            System.out.print(element+" ");
        }
    }
}
