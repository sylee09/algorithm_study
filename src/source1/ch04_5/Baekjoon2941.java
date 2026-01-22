package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] cro = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String c : cro) {
            s = s.replace(c, "*");
        }

        System.out.println(s.length());
    }
}
