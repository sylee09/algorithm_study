package ch04_5;

import java.util.Scanner;
import java.util.TreeSet;

public class Baekjoon7785 {

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            return b.compareTo(a);
        });

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String name = split[0];
            String command = split[1];

            if (command.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        for (String n : set) {
            System.out.println(n);
        }
    }
}
