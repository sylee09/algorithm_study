package source2;

import java.util.Scanner;

public class P7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                System.out.println("NO");
                return;
            }
            l++;
            r--;
        }
        System.out.println("YES");
    }
}
