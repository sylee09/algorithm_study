package source2;

import java.util.Scanner;
import java.util.Stack;

public class P12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i));
            if (sb.length() % 7 == 0) {
                Stack<Integer> stack = new Stack<>();
                for (char ch : sb.toString().toCharArray()) {
                    if (ch == '#') {
                        stack.push(1);
                    } else {
                        stack.push(0);
                    }
                }
                int num = 0;
                int idx = 0;
                while (!stack.isEmpty()) {
                    int top = stack.pop();
                    num += (top << idx);
                    idx++;
                }
                ans.append((char) num);
                sb = new StringBuilder();
            }
        }
        System.out.println(ans);
    }
}
