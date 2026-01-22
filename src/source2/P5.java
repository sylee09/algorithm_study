package source2;

import java.util.Scanner;

public class P5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String replace = str.replaceAll("[^a-zA-Z]", "");
        StringBuilder reverse = new StringBuilder(replace).reverse();

        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int idx2 = 0;

        while (idx < str.length()) {
            if (!Character.isAlphabetic(str.charAt(idx))) {
                answer.append(str.charAt(idx));
            } else {
                answer.append(reverse.charAt(idx2));
                idx2++;
            }
            idx++;
        }
        System.out.println(answer);
    }
}
