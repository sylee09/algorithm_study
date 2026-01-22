package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon9086 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String line = sc.nextLine();
            System.out.println(line.charAt(0) + "" + line.charAt(line.length() - 1));
        }
    }
}
