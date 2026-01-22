package source1.ch04_5;

import java.util.Scanner;

public class Baekjoon10951 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);
            System.out.println(A + B);
        }
    }
}
