package source1.ch04_5;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon5073 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[]{a, b, c};
            Arrays.sort(arr);

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (arr[2] >= arr[0] + arr[1]) {
                System.out.println("Invalid");
            }else if (a == b && a == c && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || a == c || b == c) {
                System.out.println("Isosceles");
            } else if (a != b && a != c && b != c) {
                System.out.println("Scalene");
            }
        }
    }
}
