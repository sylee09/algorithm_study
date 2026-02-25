package source2;

import java.util.ArrayList;
import java.util.Scanner;

public class P65 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][N];

        ArrayList<int[]> houses = new ArrayList<>();
        ArrayList<int[]> pizzas = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
                if (arr[i][j] == 2) {
                    pizzas.add(new int[]{i, j});
                }
            }
        }

        choosePizzas(pizzas, 0, M, new ArrayList<int[]>(), houses);

        System.out.println(answer);
    }

    static void choosePizzas(ArrayList<int[]> pizzas, int idx, int limit, ArrayList<int[]> chosen, ArrayList<int[]> houses) {
        if (chosen.size() == limit) {
            calculateMinDistance(chosen, houses);
            return;
        }

        for (int i = idx; i < pizzas.size(); i++) {
            chosen.add(new int[]{pizzas.get(i)[0], pizzas.get(i)[1]});
            choosePizzas(pizzas, i + 1, limit, chosen, houses);
            chosen.remove(chosen.size() - 1);
        }
    }

    static void calculateMinDistance(ArrayList<int[]> chosen, ArrayList<int[]> houses) {
        int distance = 0;

        for (int[] h : houses) {
            int minD = Integer.MAX_VALUE;
            for (int[] p : chosen) {
                int d = Math.abs(h[0] - p[0]) + Math.abs(h[1] - p[1]);
                minD = Math.min(d, minD);
            }
            distance += minD;
        }

        answer = Math.min(distance, answer);
    }
}
