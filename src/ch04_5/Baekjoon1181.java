package ch04_5;

import java.util.Scanner;
import java.util.TreeSet;

public class Baekjoon1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            int lengthA = a.length();
            int lengthB = b.length();

            if (lengthA < lengthB) {
                return -1;
            } else if (lengthA > lengthB) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            set.add(line);
        }

        while (!set.isEmpty()) {
            System.out.println(set.pollFirst());
        }
    }
}
