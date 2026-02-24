package source2;

import java.util.ArrayList;
import java.util.Scanner;

public class P60 {
    static boolean found;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        boolean[] check = new boolean[N + 1];

        dfs(0, new ArrayList<Integer>(), N, check, F);
    }

    private static void dfs(int level, ArrayList<Integer> list, int limit, boolean[] check, int bottom) {
        if (found) {
            return;
        }
        if (level == limit) {
            if (checkFunc(list, bottom)) {
                found = true;
                for (int element : list) {
                    System.out.print(element + " ");
                }
            }
            return;
        }

        for (int i = 1; i <= limit; i++) {
            if (!check[i]) {
                check[i] = true;
                list.add(i);
                dfs(level + 1, list, limit, check, bottom);
                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
    }

    private static boolean checkFunc(ArrayList<Integer> list, int bottom) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int element : list) {
            arrayList.add(element);
        }

        while (arrayList.size() != 1) {
            ArrayList<Integer> nextList = new ArrayList<>();
            for (int i = 0; i < arrayList.size() - 1; i++) {
                nextList.add(arrayList.get(i) + arrayList.get(i + 1));
            }
            arrayList = nextList;
        }

        return arrayList.get(0) == bottom ? true : false;
    }
}
