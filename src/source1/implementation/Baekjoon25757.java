package source1.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon25757 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char game = sc.next().charAt(0);
        HashMap<Character, Integer> gameMap = new HashMap<>();

        gameMap.put('Y', 1);
        gameMap.put('F', 2);
        gameMap.put('O', 3);

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            set.add(name);
        }

        int answer = set.size() / gameMap.get(game);
        System.out.println(answer);
    }
}
