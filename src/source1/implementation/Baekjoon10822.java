package source1.implementation;

import java.util.Scanner;

public class Baekjoon10822 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] split = line.split(",");

        int answer = 0;
        for (String str : split) {
            answer += Integer.parseInt(str);
        }

        System.out.println(answer);
    }
}
