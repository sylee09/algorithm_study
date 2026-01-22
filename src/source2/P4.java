package source2;

import java.util.Scanner;

public class P4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder(str);
            StringBuilder reverse = sb.reverse();
            System.out.println(reverse);
        }
    }
}
