package ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon1620 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = sc.nextLine();
            map1.put(name, i);
            map2.put(i, name);
        }

        for (int i = 1; i <= M; i++) {
            String line = sc.nextLine();
            if (Character.isDigit(line.charAt(0))) {
                int num = Integer.valueOf(line);
                System.out.println(map2.get(num));
            } else {
                System.out.println(map1.get(line));
            }
        }
    }
}
