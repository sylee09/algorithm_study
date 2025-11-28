package ch04_5;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon2745 {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 10;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, num++);
        }
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int digit = Integer.parseInt(split[1]);
        int answer = 0;
        int n = 0;
        for (int idx = split[0].length() - 1; idx >= 0; idx--) {
            if (map.containsKey(split[0].charAt(idx))) {
                answer += (map.get(split[0].charAt(idx)) * Math.pow(digit, n++));
            } else {
                int x = Integer.parseInt(String.valueOf(split[0].charAt(idx)));
                answer += x * Math.pow(digit, n++);
            }
        }
        System.out.println(answer);
    }
}
