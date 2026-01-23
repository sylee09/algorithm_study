package source2;

import java.util.HashSet;
import java.util.Scanner;

public class P6 {

    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder answer = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                answer.append(ch);
                set.add(ch);
            }
        }
        System.out.println(answer);
    }
}
