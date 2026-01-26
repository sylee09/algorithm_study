package source2;

import java.util.Scanner;

public class P15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int a = arr1[i];
            int b = arr2[i];

            int result = whoWin(a, b);
            if (result == 0) {
                System.out.println("D");
            } else if (result == 1) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

    static int whoWin(int a, int b) {
        if (a == b) {
            return 0;
        }

        if (a == 1) {
            if (b == 2) {
                return 2;
            } else {
                return 1;
            }
        } else if (a == 2) {
            if (b == 3) {
                return 2;
            } else {
                return 1;
            }
        } else if (a == 3) {
            if (b == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        return -1;
    }
}
