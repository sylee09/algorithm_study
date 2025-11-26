package ch04_5;

import java.util.Scanner;

public class Baekjoon2675 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int tc = 0; tc < T; tc++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int r = Integer.parseInt(split[0]);
            StringBuilder sb = new StringBuilder();
            for (char ch : split[1].toCharArray()) {
                for (int i = 0; i < r; i++) {
                    sb.append(ch);
                }
            }
            System.out.println(sb);
        }
    }
}
