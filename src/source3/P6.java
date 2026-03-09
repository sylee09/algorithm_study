package source3;

import java.util.*;

class P6 {
    public int solution(int[][] fruit){
        boolean[] check = new boolean[fruit.length];
        for (int i = 0; i < fruit.length; i++) {
            if (checkFunc(i, check)) {
                continue;
            }
            int smallestIndex = findSmallest(fruit[i]);
            if (duplicated(fruit[i], smallestIndex)) {
                continue;
            }

            for (int j = i + 1; j < fruit.length; j++) {
                if (checkFunc(j, check)) {
                    continue;
                }
                int smallestIndex2 = findSmallest(fruit[j]);
                if (duplicated(fruit[j], smallestIndex2)) {
                    continue;
                }

                if (smallestIndex != smallestIndex2 && fruit[i][smallestIndex] + 1 <= fruit[i][smallestIndex2] - 1 && fruit[j][smallestIndex2] + 1 <= fruit[j][smallestIndex] - 1) {
                    check[i] = true;
                    check[j] = true;
                    fruit[i][smallestIndex] += 1;
                    fruit[i][smallestIndex2] -= 1;
                    fruit[j][smallestIndex] -= 1;
                    fruit[j][smallestIndex2] += 1;
                    break;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < fruit.length; i++) {
            int idx = findSmallest(fruit[i]);
            answer += fruit[i][idx];
        }

        return answer;
    }

    public boolean checkFunc(int i, boolean[] check) {
        return check[i];
    }

    public boolean duplicated(int[] fruit, int idx) {
        for (int i = 0; i < 3; i++) {
            if (i != idx && fruit[i] == fruit[idx]) {
                return true;
            }
        }
        return false;
    }

    public int findSmallest(int[] fruit) {
        int smallestIndex = 0;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (fruit[i] < smallest) {
                smallest = fruit[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
