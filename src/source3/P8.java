package source3;

import java.util.*;
class P8 {
    public int[] solution(int[] enter, int[] exit){
        for (int i = 0; i < enter.length; i++) {
            enter[i]--;
            exit[i]--;
        }

        // enterIdx[0]=0 => 0이 0번째
        // enterIdx[1]=2 =? 1이 2번째
        int[] enterIdx = new int[enter.length];

        for (int i = 0; i < enter.length; i++) {
            enterIdx[enter[i]] = i;
        }

        int[] enterT = new int[enter.length];
        int[] exitT = new int[enter.length];
        int time = 0;

        for (int i = 0, j = 0; i < enter.length; i++) {
            while (j < enter.length && j <= enterIdx[exit[i]]) {
                enterT[enter[j]] = time++;
                j++;
            }
            exitT[exit[i]] = time++;
        }

        int[] answer = new int[enter.length];
        for (int i = 0; i < enter.length; i++) {
            for (int j = i + 1; j < enter.length; j++) {
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        P8 T = new P8();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}