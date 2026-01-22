package source2;

import java.util.Scanner;

public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int maxLength = 0;
        String answer = "";

        for (String s : split) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                answer = s;
            }
        }

        System.out.println(answer);
    }
}
