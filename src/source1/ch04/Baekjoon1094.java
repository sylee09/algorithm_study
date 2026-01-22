package source1.ch04;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int length = 64;
        if (X == length) {
            System.out.println(1);
            return;
        }
        // dfs
        // list에 Xcm 만들 막대들 저장
        dfs(X, length, 64, new ArrayList<Integer>());
    }

    static void dfs(int X, int length, int totalLength, ArrayList<Integer> list) {
        if (totalLength == X) {
            System.out.println(list.size());
            return;
        }

        int half = length / 2;
        int nextTotalLength = totalLength - half;
        if (nextTotalLength >= X) {
            if (nextTotalLength == X) {
                list.add(half);
            }
            dfs(X, half, nextTotalLength, list);
        } else {
            list.add(half);
            dfs(X, half, totalLength, list);
        }
    }
}
