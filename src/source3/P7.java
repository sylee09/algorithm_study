package source3;

import java.util.Arrays;
import java.util.HashMap;

class P7 {
    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[] keypad, String password){
        HashMap<String, int[]> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int key = keypad[idx++];
                map.put(String.valueOf(key), new int[]{i, j});
            }
        }

        int[] cur = map.get(String.valueOf(password.charAt(0)));
        int answer = 0;

        for (int i = 1; i < password.length(); i++) {
            String p = String.valueOf(password.charAt(i));
            int[] next = map.get(p);
            int curX = cur[0];
            int curY = cur[1];

            int nextX = next[0];
            int nextY = next[1];

            if (curX == nextX && curY == nextY) {
                continue;
            }

            boolean found = false;
            for (int k = 0; k < dx.length; k++) {
                if (curX + dx[k] == nextX && curY + dy[k] == nextY) {
                    answer += 1;
                    found = true;
                    break;
                }
            }

            if (!found) {
                answer += 2;
            }

            cur = next;
        }

        return answer;
    }

    public static void main(String[] args){
        P7 T = new P7();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}