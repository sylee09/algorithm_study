package source3.simulation;

import java.util.*;

class P1 {
    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 'A');
        }

        for (int[] l : ladder) {
            for (int element : l) {
                int idx = element - 1;
                swap(answer, idx);
            }
        }

        return answer;
    }

    public void swap(char[] answer, int idx) {
        char origin = answer[idx];
        char target = answer[idx + 1];

        answer[idx] = target;
        answer[idx + 1] = origin;
    }

    public static void main(String[] args) {
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}