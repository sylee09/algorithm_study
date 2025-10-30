package ch01;

import java.util.Scanner;

public class Baekjoon10808 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        // 배열에 S에 들어간 알파벳 cnt 저장
        int[] cnt = new int[26];
        for (char ch : S.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (int i = 0; i < cnt.length; i++) {
            System.out.print(cnt[i]+" ");
        }
    }
}
