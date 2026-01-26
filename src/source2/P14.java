package source2;

import java.util.Scanner;
import java.util.Stack;

public class P14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int element : arr) {
            if (stack.isEmpty()) {
                stack.push(element);
            } else {
                if (stack.peek() < element) {
                    stack.push(element);
                }
            }
        }

        System.out.println(stack.size());
    }
}
