package source1.ch1;

import java.util.Scanner;

public class Ch1_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder answer = new StringBuilder();

        for (char ch : line.toCharArray()) {
            int i;
            if (ch >= 'A' && ch <= 'Z') {
                i = (ch + 13 - 'A') % 26;
                answer.append((char) (i + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                i = (ch + 13 - 'a') % 26;
                answer.append((char) (i + 'a'));
            } else {
                answer.append(ch);
            }
        }

        System.out.println(answer);
    }
}
