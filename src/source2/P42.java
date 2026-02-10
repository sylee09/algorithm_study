package source2;

import java.util.Scanner;
import java.util.Stack;

public class P42 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        Stack<Integer> stack = new Stack<>();
        for (char ch : str1.toCharArray()) {
            int idx = str2.indexOf(ch);
            if (idx == -1) {
                System.out.println("NO");
                return;
            }
            if (stack.isEmpty()) {
                stack.push(idx);
            } else {
                if (stack.peek() > idx) {
                    System.out.println("NO");
                    return;
                }
                stack.push(idx);
            }
        }
        if (stack.size() == str1.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
