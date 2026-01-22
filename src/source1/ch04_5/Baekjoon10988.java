package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon10988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int l = 0;
        int r = line.length() - 1;

        while (l < r) {
            if (line.charAt(l) != line.charAt(r)) {
                System.out.println(0);
                return;
            }
            l++;
            r--;
        }
        System.out.println(1);
    }
}
