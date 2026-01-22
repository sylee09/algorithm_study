package source1.ch04_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1427 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        for (int i = 0; i < line.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(line.charAt(i))));
        }

        list.sort((a, b) -> {
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            }
            return 0;
        });

        StringBuilder answer = new StringBuilder();

        for (int element : list) {
            answer.append(element);
        }
        System.out.println(answer);
    }
}
