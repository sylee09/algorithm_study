package ch02;

import java.util.Scanner;

public class Baekjoon10709 {

    public static void main(String[] args) {
        //입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }


        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'c') {
                    ans.append(0 + " ");
                } else {
                    int dist = 0;
                    boolean found = false;
                    for (int k = j; k >= 0; k--) {
                        if (arr[i][k] == 'c') {
                            ans.append(dist + " ");
                            found = true;
                            break;
                        }
                        dist++;
                    }
                    if (!found) {
                        ans.append(-1 + " ");
                    }
                }
            }
            ans.append("\n");
        }
        System.out.println(ans.toString());
    }
}
