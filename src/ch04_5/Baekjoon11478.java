package ch04_5;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon11478 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        HashSet<String> set = new HashSet<>();

        for (int l = 1; l <= S.length(); l++) {
            for (int i = 0; i <= S.length() - l; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < i + l; j++) {
                    sb.append(S.charAt(j));
                }
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}
