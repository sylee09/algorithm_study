package source1.ch01;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon1620 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        sc.nextLine();

        // map에 집어넣기
        for (int i = 1; i <= N; i++) {
            String pokemon = sc.nextLine();
            map1.put(i, pokemon);
            map2.put(pokemon, i);
        }

        for (int i = 1; i <= M; i++) {
            String line = sc.nextLine();
            if ((Character.isDigit(line.charAt(0)))) {
                System.out.println(map1.get(Integer.parseInt(line)));
            } else {
                System.out.println(map2.get(line));
            }
        }
    }
}
