package book1.ch6;

import java.util.Stack;

public class Ch6_6 {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int m = board[0].length;
        Stack<Integer>[] stacks = new Stack[m];
        for (int i = 0; i < m; i++) {
            stacks[i] = new Stack<Integer>();
        }
        Stack<Integer> answerStack = new Stack<>();


        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    stacks[j].push(board[i][j]);
                }
            }
        }

        int answer = 0;
        for (int mv : moves) {
            mv -= 1;
            if (!stacks[mv].isEmpty()) {
                Integer pop = stacks[mv].pop();
                if (answerStack.isEmpty()) {
                    answerStack.push(pop);
                } else {
                    if (answerStack.peek().equals(pop)) {
                        answerStack.pop();
                        answer += 2;
                    } else {
                        answerStack.push(pop);
                    }
                }
            }
        }
        return answer;
    }
}
