package source1.ch1;

import java.util.Scanner;


public class Ch1_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String pattern = sc.nextLine();
        int idxStar = pattern.indexOf('*');
        String pre = pattern.substring(0, idxStar);
        String post = pattern.substring(idxStar + 1);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            if (line.length() >= pre.length() + post.length() &&
                    line.startsWith(pre) && line.endsWith(post)
            ) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }

        }
    }
}
