package source2;

import java.util.ArrayList;
import java.util.Scanner;

public class P10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        String s = split[0];
        char c = split[1].charAt(0);
        ArrayList<Integer> targetPosition = new ArrayList<>();

        int idx = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                targetPosition.add(idx);
            }
            idx++;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int targetIdx : targetPosition) {
                if (Math.abs(targetIdx - i) < min) {
                    min = Math.abs(targetIdx - i);
                }
            }
            answer.add(min);
        }

        for (int element : answer) {
            System.out.print(element + " ");
        }
    }
}
