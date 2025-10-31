package ch01;

import java.util.Scanner;

public class Baekjoon11655 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        // sb에 정답 저장
        StringBuilder sb = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (ch == ' ' || Character.isDigit(ch)) {
                sb.append(ch);
            }
            if (Character.isUpperCase(ch)) {
                int newCh = ch + 13;
                if (newCh > 'Z') {
                    newCh = newCh % 'Z' + 'A' - 1;
                    sb.append((char) newCh);
                } else {
                    sb.append((char) newCh);
                }
            } else if (Character.isLowerCase(ch)) {
                int newCh = ch + 13;
                if (newCh > 'z') {
                    newCh = newCh % 'z' + 'a' - 1;
                    sb.append((char) newCh);
                } else {
                    sb.append((char) newCh);
                }
            }
        }
        System.out.println(sb);
    }
}
