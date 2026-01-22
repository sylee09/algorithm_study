package source1.ch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (!arr[i]) {
                continue;
            }
            for (int j = i; i * j <= N; j++) {
                arr[i * j] = false;
            }
        }

        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                prime.add(i);
            }
        }

        int num = 0;
        int left = 0, right = 0;
        int answer = 0;

        while (right < prime.size()) {
            num += prime.get(right++);
            while (num > N) {
                num -= prime.get(left++);
            }
            if (num == N) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
