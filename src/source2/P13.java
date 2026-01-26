package source2;

import java.util.Scanner;

public class P13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int before = -1;
        for (int idx = 0; idx < N; idx++) {
            int cur = arr[idx];
            if (before < cur) {
                ans.append(cur+" ");
            }
            before = cur;
        }

        System.out.println(ans);
    }
}
