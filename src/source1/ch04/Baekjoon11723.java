package source1.ch04;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon11723 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            String command = split[0];
            int num = 0;
            if (split.length > 1) {
                num = Integer.parseInt(split[1]);
            }

            if (command.equals("add")) {
                set.add(num);
            }

            if (command.equals("check")) {
                boolean result = set.contains(num);
                if (result) {
                    bw.append(1 + "\n");
                } else {
                    bw.append(0 + "\n");
                }
            }

            if (command.equals("remove")) {
                set.remove(num);
            }

            if (command.equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }

            if (command.equals("all")) {
                set.clear();
                for (int x = 1; x <= 20; x++) {
                    set.add(x);
                }
            }

            if (command.equals("empty")) {
                set.clear();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
