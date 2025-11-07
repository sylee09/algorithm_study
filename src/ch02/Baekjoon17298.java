package ch02;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon17298 {

    public static void main(String[] args) throws IOException {
        // [num, idx]
        Stack<int[]> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];


        String line = br.readLine();
        String[] split = line.split(" ");

        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            if (stack.isEmpty()) {
                stack.push(new int[]{num, i});
            } else {
                // 집어넣는 숫자보다 더 큰게 top에 있을때까지 pop하고 push
                // pop된것의 ans[idx] = num
                while (!stack.isEmpty() && stack.peek()[0] < num) {
                    int[] pop = stack.pop();
                    ans[pop[1]] = num;
                }
                stack.push(new int[]{num, i});
            }
        }

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            ans[pop[1]] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num : ans) {
            bw.append(num + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
