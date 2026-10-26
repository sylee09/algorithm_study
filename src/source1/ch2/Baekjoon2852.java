package source1.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon2852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int k = Integer.parseInt(line);

        int f = 0;
        int s = 0;

        Stack<int[]> stack = new Stack<>();

        for (int x = 0; x < k; x++) {
            line = br.readLine();
            String[] split = line.split(" ");
            int num = Integer.parseInt(split[0]);
            int time = 0;
            String[] timeSplit = split[1].split(":");
            time += (Integer.parseInt(timeSplit[0]) * 60);
            time += Integer.parseInt(timeSplit[1]);
            if (stack.isEmpty()) {
                stack.push(new int[]{num, time});
            } else {
                int[] peek = stack.peek();
                int peekNum = peek[0];
                int peekTime = peek[1];

                if (peekNum == num) {
                    stack.push(new int[]{num, time});
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        if (peekNum == 1) {
                            f += (time - peekTime);
                        } else if (peekNum == 2) {
                            s += (time - peekTime);
                        }
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            while (stack.size() > 1) {
                stack.pop();
            }
            int[] pop = stack.pop();
            if (pop[0] == 1) {
                f += (60 * 48 - pop[1]);
            } else {
                s += (60 * 48 - pop[1]);
            }
        }

        System.out.printf("%02d:%02d%n%02d:%02d%n", f / 60, f % 60, s / 60, s % 60);
    }
}
