package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon2292 {

    public static void main(String[] args) {
        int level = 1;
        int start = 1;
        int end = 1;
        Scanner sc = new Scanner(System.in);
        int roomNum = sc.nextInt();

        while (true) {
            if (roomNum >= start && roomNum <= end) {
                System.out.println(level);
                break;
            }
            start = end + 1;
            end = end + (6 * level);
            level++;
        }
    }
}
