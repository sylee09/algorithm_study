package source2;

import java.util.Scanner;

public class P8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toLowerCase();
        line = line.replaceAll("[^a-zA-Z]", "");
        int l = 0;
        int r = line.length() - 1;

        while (l < r) {
            if (line.charAt(l) != line.charAt(r)) {
                System.out.println("NO");
                return;
            }
            l++;
            r--;
        }
        System.out.println("YES");
    }
}
