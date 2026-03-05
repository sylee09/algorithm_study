package source3;

import java.util.*;

class P1 {
    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        // 사다리 생성
        boolean[][] createdLadder = new boolean[ladder.length + 1][n + 1];

        int level = 0;
        for (int[] l : ladder) {
            for (int element : l) {
                createdLadder[level][element] = true;
            }
            level++;
        }

//        for (int i = 0; i < createdLadder.length; i++) {
//            for (int j = 0; j < createdLadder[0].length; j++) {
//                System.out.print(createdLadder[i][j]+" ");
//            }
//            System.out.println();
//        }

        // 사다리 타기
        for (int i = 1; i <= n; i++) {
            level = 0;
            int cur = i;
            while (level < createdLadder.length) {
//                System.out.println("cur: " + level + ", " + cur);
                // 현재 위치가 true인 경우 오른쪽으로 이동
                if (createdLadder[level][cur]) {
                    cur++;
                }
                // 현재 위치 왼쪽이 true인 경우 왼쪽으로 이동
                else if (createdLadder[level][cur - 1]) {
                    cur--;
                }
                level++;
            }
            int ans = 'A' + i - 1;
            answer[cur - 1] = (char) ans;
        }
        return answer;
    }

    public static void main(String[] args) {
        P1 T = new P1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}