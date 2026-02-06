package source2;

import java.util.Scanner;
import java.util.Stack;

public class P38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Stack[] stacks = new Stack[N];

        for (int j = 0; j < N; j++) {
            stacks[j] = new Stack<Integer>();
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i][j] == 0) {
                    continue;
                }
                stacks[j].add(arr[i][j]);
            }
        }

        int mvCount = sc.nextInt();
        int[] moves = new int[mvCount];
        for (int i = 0; i < mvCount; i++) {
            moves[i] = sc.nextInt() - 1;
        }
        Stack<Integer> ansStack = new Stack<>();
        int answer = 0;

        for (int mv : moves) {
            if (!stacks[mv].isEmpty()) {
                int pop = (int) stacks[mv].pop();
//                System.out.println("pop: " + pop);
                if (!ansStack.isEmpty()) {
                    if (ansStack.peek() == pop) {
                        answer += 2;
                        ansStack.pop();
                    } else {
                        ansStack.push(pop);
                    }
                }else {
                    ansStack.push(pop);
                }
//                System.out.println(ansStack);
            }
        }

        System.out.println(answer);

    }
}
