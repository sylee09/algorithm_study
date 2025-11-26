package ch04_5;

import java.util.Scanner;

public class Baekjoon25206 {

    public static void main(String[] args) {
        double hakjum = 0;
        double grade = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            double h = Double.parseDouble(split[1]);
            hakjum += h;

            if (split[2].equals("A+")) {
                grade += 4.5 * h;
            } else if (split[2].equals("A0")) {
                grade += 4.0 * h;
            } else if (split[2].equals("B+")) {
                grade += 3.5 * h;
            } else if (split[2].equals("B0")) {
                grade += 3.0 * h;
            } else if (split[2].equals("C+")) {
                grade += 2.5 * h;
            } else if (split[2].equals("C0")) {
                grade += 2.0 * h;
            } else if (split[2].equals("D+")) {
                grade += 1.5 * h;
            } else if (split[2].equals("D0")) {
                grade += 1.0 * h;
            } else if (split[2].equals("P")){
                hakjum -= h;
            }
        }
        double answer = grade / hakjum;
        System.out.printf("%.6f",answer);
    }
}
