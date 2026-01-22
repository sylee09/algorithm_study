package source1.ch04_5;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon14425 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            set.add(line);
        }

        int ans = 0;

        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            if (set.contains(line)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
