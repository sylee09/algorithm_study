package source3;

import java.util.*;

class P6 {

    public int getMin(int[] f) {
        int min = 100;
        for (int x : f) {
            min = Math.min(min, x);
        }
        return min;
    }

    public boolean isMinUnique(int[] f) {
        int cnt = 0;
        int min = getMin(f);
        for (int x : f) {
            if(x==min) cnt++;
        }
        return cnt == 1;
    }

    public int getMinIndex(int[] f) {
        int min = getMin(f);
        for (int i = 0; i < 3; i++) {
            if (f[i] == min) {
                return i;
            }
        }
        return 0;
    }

    public int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if(ch[i]==1) continue;
            if(!isMinUnique(fruit[i])) continue;
            for (int j = i + 1; j < n; j++) {
                if(ch[j]==1) continue;
                if(!isMinUnique(fruit[j])) continue;
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] x : fruit) {
            answer += getMin(x);
        }
        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}