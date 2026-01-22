package source2;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 대문자->소문자, 소문자->대문자 변환
        StringBuilder answer = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                answer.append(Character.toLowerCase(ch));
            } else {
                answer.append(Character.toUpperCase(ch));
            }
        }

        System.out.println(answer);
    }
}
