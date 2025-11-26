package ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon5622 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('1', 2);
        for (char A = 'A'; A <= 'Z'; A++) {
            if (A >= 'A' && A <= 'C') {
                map.put(A, 3);
            } else if (A >= 'D' && A <= 'F') {
                map.put(A, 4);
            } else if (A >= 'G' && A <= 'I') {
                map.put(A, 5);
            } else if (A >= 'J' && A <= 'L') {
                map.put(A, 6);
            } else if (A >= 'M' && A <= 'O') {
                map.put(A, 7);
            } else if (A >= 'P' && A <= 'S') {
                map.put(A, 8);
            } else if (A >= 'T' && A <= 'V') {
                map.put(A, 9);
            } else if (A >= 'W' && A <= 'Z') {
                map.put(A, 10);
            }
        }

        String line = sc.nextLine();
        int ans = 0;
        for (char ch : line.toCharArray()) {
            ans += map.get(ch);
        }
        System.out.println(ans);
    }
}
