package book1;

import java.util.Arrays;
import java.util.Stack;

public class Ch6_7 {

    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k++;

        Stack<Integer> deleted = new Stack<>();
        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                k = down[k] > n ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                Integer pop = deleted.pop();
                down[up[pop]] = pop;
                up[down[pop]] = pop;
            } else {
                int idx = Integer.parseInt(c.split(" ")[1]);
                if (c.startsWith("U")) {
                    for (int i = 0; i < idx; i++) {
                        k = up[k];
                    }
                } else if (c.startsWith("D")) {
                    for (int i = 0; i < idx; i++) {
                        k = down[k];
                    }
                }
            }
        }

        char[] answerArr = new char[n];
        Arrays.fill(answerArr, 'O');

        while (!deleted.isEmpty()) {
            Integer pop = deleted.pop() - 1;
            answerArr[pop] = 'X';
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : answerArr) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
