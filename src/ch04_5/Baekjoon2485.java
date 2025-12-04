package ch04_5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon2485 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        list.sort((a, b) -> {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        });
        ArrayList<Integer> diffList = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            int j = i - 1;
            diffList.add(list.get(i) - list.get(j));
        }

        int gcd = gcd(diffList);

        int answer = (int) Math.ceil((double) list.get(list.size() - 1) / gcd);
        answer -= (int) Math.ceil((double) list.get(0) / gcd);
        answer += 1;
        answer -= list.size();

        System.out.println(answer);
    }

    static int gcd(ArrayList<Integer> list) {
        for (int num = list.get(0); num >= 1; num--) {
            boolean flag = true;
            for (int element : list) {
                if (element % num != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return num;
            }
        }
        return 1;
    }
}
