package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon1152 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (line.isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] split = line.split(" ");
        int cnt = 0;
        for (String s : split) {
            if (!s.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
