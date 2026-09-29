package source1.ch1;

import java.util.HashMap;
import java.util.Scanner;

public class Ch1_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> map = new HashMap<>();
            for (int x = 0; x < n; x++) {
                String line = sc.nextLine();
                String[] split = line.split(" ");
                map.put(split[1], map.getOrDefault(split[1], 0) + 1);
            }
            int answer = 1;
            for (int val : map.values()) {
                answer *= (val + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
