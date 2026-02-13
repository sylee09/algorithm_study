package source2;

import java.util.HashSet;
import java.util.Scanner;

public class P48 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (set.contains(num)) {
                System.out.println("D");
                return;
            }
            set.add(num);
        }
        System.out.println("U");
    }
}
