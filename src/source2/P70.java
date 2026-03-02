package source2;

import java.util.Scanner;

public class P70 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(arr, a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        String answer = find(a, arr) == find(b, arr) ? "YES" : "NO";

        System.out.println(answer);
    }

    static int find(int x, int[] arr) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x], arr);
    }

    static void union(int[] arr, int a, int b) {
        int rootA = find(a, arr);
        int rootB = find(b, arr);

        if (rootA != rootB) {
            arr[rootB] = rootA;
        }
    }
}
