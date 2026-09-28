package source1.ch1;

import java.util.HashMap;
import java.util.Scanner;

public class Ch1_9 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        int idx = 1;
        for (int i = 0; i < n; i++) {
            String pokemon = sc.nextLine();
            map1.put(pokemon, idx);
            map2.put(idx, pokemon);
            idx++;
        }

        for (int i = 0; i < m; i++) {
            String q = sc.nextLine();
            if (map1.containsKey(q)) {
                System.out.println(map1.get(q));
            } else {
                System.out.println(map2.get(Integer.parseInt(q)));
            }
        }
    }
}
