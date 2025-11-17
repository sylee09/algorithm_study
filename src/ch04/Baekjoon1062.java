package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon1062 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        if (K < 5) {
            System.out.println(0);
            return;
        }

        HashSet<Character>[] strSets = new HashSet[N];
        for (int i = 0; i < N; i++) {
            strSets[i] = new HashSet<Character>();
        }

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (char ch : line.toCharArray()) {
                strSets[i].add(ch);
            }
        }

        // 백트래킹
        HashSet<Character> set = new HashSet<>();
        char[] chs = new char[]{'a', 'n', 't', 'i', 'c'};
        for (char ch : chs) {
            set.add(ch);
        }
        char[] alphabet = new char[]{'b', 'd', 'e', 'f', 'g',
                'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r',
                's', 'u', 'v', 'w', 'x', 'y', 'z'};

        backtracking(set, alphabet, K, strSets, 0);
        System.out.println(answer);
    }

    static void backtracking(HashSet<Character> set, char[] alphabet, int limit, HashSet<Character>[] strSets, int idx) {
        if (set.size() == limit) {
            int cnt = 0;
            for (HashSet<Character> str : strSets) {
                if (set.containsAll(str)) {
                    cnt++;
                }
            }
            if (cnt > answer) {
                answer = cnt;
            }
            return;
        }

        // 순열이 아닌 조합을 찾아야함
        for (int i = idx; i < alphabet.length; i++) {
            if (!set.contains(alphabet[i])) {
                set.add(alphabet[i]);
                backtracking(set, alphabet, limit, strSets, i + 1);
                set.remove(alphabet[i]);
            }
        }
    }
}
