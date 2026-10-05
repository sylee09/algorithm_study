package source1.implementation;

import java.util.Scanner;

public class Baekjoon20125 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int headRow = -1;
        int headCol = -1;

        for (int i = 0; i < n; i++) {
            if (headRow != -1) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '*') {
                    headRow = i;
                    headCol = j;
                }
            }
        }
        StringBuilder answerStr = new StringBuilder();

        answerStr.append((headRow + 2) + " " + (headCol + 1) + "\n");


        int leftArm = 0;
        for (int j = headCol - 1; j >= 0; j--) {
            if (arr[headRow + 1][j] == '*') {
                leftArm++;
            }
        }

        answerStr.append(leftArm + " ");

        int rightArm = 0;
        for (int j = headCol + 1; j < n; j++) {
            if (arr[headRow + 1][j] == '*') {
                rightArm++;
            }
        }
        answerStr.append(rightArm + " ");

        int spine = 0;
        for (int i = headRow + 2; i < n; i++) {
            if (arr[i][headCol] == '*') {
                spine++;
            }
        }
        answerStr.append(spine + " ");

        int startRow = headRow + spine + 2;
        int startCol = headCol - 1;

        int leftLeg = 0;
        for (int i = startRow; i < n; i++) {
            if (arr[i][startCol] == '*') {
                leftLeg++;
            }
        }
        answerStr.append(leftLeg + " ");

        startCol = headCol + 1;
        int rightLeg = 0;
        for (int i = startRow; i < n; i++) {
            if (arr[i][startCol] == '*') {
                rightLeg++;
            }
        }
        answerStr.append(rightLeg);

        System.out.println(answerStr);
    }
}
