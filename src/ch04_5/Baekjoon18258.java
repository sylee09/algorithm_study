package ch04_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Baekjoon18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            String command = split[0];

            if (command.equals("push")) {
                list.offer(Integer.parseInt(split[1]));
            } else {
                if (command.equals("front")) {
                    if (list.isEmpty()) {
                        ans.append("-1\n");
                    } else {
                        ans.append(list.getFirst() + "\n");
                    }
                } else if (command.equals("pop")) {
                    if (list.isEmpty()) {
                        ans.append("-1\n");
                    } else {
                        ans.append(list.poll() + "\n");
                    }
                } else if (command.equals("size")) {
                    ans.append(list.size() + "\n");
                } else if (command.equals("empty")) {
                    if (list.isEmpty()) {
                        ans.append(1 + "\n");
                    } else {
                        ans.append(0 + "\n");
                    }
                } else if (command.equals("back")) {
                    if (list.isEmpty()) {
                        ans.append(-1 + "\n");
                    } else {
                        ans.append(list.getLast() + "\n");
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
