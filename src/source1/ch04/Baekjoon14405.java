package source1.ch04;

import java.util.Scanner;

public class Baekjoon14405 {
    static boolean found = false;

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean canMake = true;
        int i = 0;
        while (i < str.length()) {
            if (str.startsWith("pi", i)) {
                i += 2;
            } else if (str.startsWith("ka", i)) {
                i += 2;
            } else if (str.startsWith("chu", i)) {
                i += 3;
            } else {
                canMake = false;
                break;
            }
        }

        if (canMake) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
