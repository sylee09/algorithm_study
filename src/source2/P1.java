package source2;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().toLowerCase();
        char ch = sc.nextLine().toLowerCase().charAt(0);

        int cnt = 0;

        for (char c : str1.toCharArray()) {
            if (c == ch) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
