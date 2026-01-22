package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon27866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int n = sc.nextInt() - 1;
        System.out.println(S.charAt(n));
    }
}
