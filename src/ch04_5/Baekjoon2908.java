package ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2908 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int[] nums = new int[2];

        int idx = 0;
        for (String str : split) {
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            nums[idx++] = Integer.parseInt(sb.toString());
        }

        System.out.println(Arrays.stream(nums).max().getAsInt());
    }
}
