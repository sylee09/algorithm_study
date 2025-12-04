package ch04_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] status = new int[N];
        int[] numbers = new int[N];
        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            status[i] = Integer.parseInt(split[i]);
        }
        line = br.readLine();
        split = line.split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (status[i] == 0) {
                deque.offer(numbers[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        line = br.readLine();
        split = line.split(" ");

        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(split[i]);
            deque.offerFirst(c);
            ans.append(deque.pollLast() + " ");
        }
        System.out.println(ans);
    }
}
