package source1.ch04;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon5430 {

    public static void main(String[] args) {
        // 입력받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int tc = 0; tc < T; tc++) {
            String p = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();

            LinkedList<Integer> list = new LinkedList<>();
            String num = sc.nextLine();
            num = num.replace("[", "");
            num = num.replace("]", "");
            String[] nums = num.split(",");
            for (String a : nums) {
                if (n != 0) {
                    list.add(Integer.parseInt(a));
                }
            }

            boolean isReversed = false;
            boolean flag = false;
            for (char ch : p.toCharArray()) {
                if (ch == 'R') {
                    isReversed = !isReversed;
                } else if (ch == 'D') {
                    if (list.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (isReversed) {
                        list.pollLast();
                    } else {
                        list.poll();
                    }
                }
            }
            if (flag) {
                System.out.println("error");
                continue;
            }

            StringBuilder answer = new StringBuilder();
            answer.append("[");

            if (isReversed) {
                while (!list.isEmpty()) {
                    answer.append(list.pollLast() + ",");
                }
            } else {
                while (!list.isEmpty()) {
                    answer.append(list.poll() + ",");
                }
            }
            if (answer.length() > 1) {
                answer.delete(answer.length() - 1, answer.length());
            }
            answer.append("]");
            System.out.println(answer);
        }
    }
}
