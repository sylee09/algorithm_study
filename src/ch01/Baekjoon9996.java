package ch01;

import java.util.Scanner;

public class Baekjoon9996 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String pattern = sc.nextLine();
        String[] fileName = new String[N];

        for (int i = 0; i < N; i++) {
            fileName[i] = sc.nextLine();
        }

        // *을 기준으로 패턴을 나누기
        String[] split = pattern.split("\\*");
        String leftPattern = split[0];
        String rightPattern = split[1];
        int leftPatternLength = leftPattern.length();
        int rightPatternLength = rightPattern.length();

        for (String fn : fileName) {
            // 만약 패턴 길이가 더 길면 패턴일치 X
            if (leftPatternLength + rightPatternLength > fn.length()) {
                System.out.println("NE");
                continue;
            }
            String leftFileName = fn.substring(0, leftPatternLength);
            String rightFileName = fn.substring(fn.length() - rightPatternLength);

            // *을 기준으로 왼쪽과 파일 left 부분 비교하고 *을 기준으로 오른쪽과 파일 right 부분 비교
            if (!leftPattern.equals(leftFileName) || !rightPattern.equals(rightFileName)) {
                System.out.println("NE");
                continue;
            }
            System.out.println("DA");
        }
    }
}
