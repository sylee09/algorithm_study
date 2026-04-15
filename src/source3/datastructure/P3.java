package source3.datastructure;

import java.util.*;

public class P3 {

    public int[] solution(int[] arrival, int[] state){
        int prev = 1;
        ArrayDeque<Integer> enter = new ArrayDeque<>();
        ArrayDeque<Integer> exit = new ArrayDeque<>();
        int n = arrival.length;
        int[] answer = new int[n];

        for (int time = 0, idx = 0, count = 0; ; time++) {
            if (idx < n && enter.isEmpty() && exit.isEmpty()) {
                if (time < arrival[idx]) {
                    time = arrival[idx];
                }
                prev = 1;
            }

            while (idx < n && time >= arrival[idx]) {
                int st = state[idx];

                if (st == 1) {
                    exit.add(idx);
                } else {
                    enter.add(idx);
                }
                idx++;
            }

            if (prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = time;
                    prev = 1;
                } else if (!enter.isEmpty()) {
                    answer[enter.poll()] = time;
                    prev = 0;
                }
            } else {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = time;
                    prev = 0;
                } else if (!exit.isEmpty()) {
                    answer[exit.poll()] = time;
                    prev = 1;
                }
            }
            count++;
            if (count == n) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
