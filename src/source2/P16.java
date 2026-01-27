package source2;

import java.util.HashMap;
import java.util.Scanner;

public class P16 {
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        fibonacci(N);

        for (int i = 0; i < N; i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    private static int fibonacci(int N) {
        if (N < 0) {
            return 0;
        }

        if (map.containsKey(N)) {
            return map.get(N);
        }

        int val = fibonacci(N - 1) + fibonacci(N - 2);
        map.put(N, val);
        return val;
    }
}
