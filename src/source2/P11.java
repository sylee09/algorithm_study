package source2;

import java.util.Scanner;

public class P11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder answer = new StringBuilder();

        char before = line.charAt(0);
        int cnt = 1;

        for (int i = 1; i < line.length(); i++) {
            if (before != line.charAt(i)) {
                if (cnt > 1) {
                    answer.append(before).append(cnt);
                } else {
                    answer.append(before);
                }
                cnt = 1;
                before = line.charAt(i);
            } else {
                cnt++;
            }
        }
        if (cnt > 1) {
            answer.append(before).append(cnt);
        } else {
            answer.append(before);
        }
        System.out.println(answer);

    }
}
