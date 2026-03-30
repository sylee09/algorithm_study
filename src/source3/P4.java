package source3;

import java.util.Arrays;

public class P4 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int[] solution(int c, int r, int k){
        boolean[][] check = new boolean[r][c];

        int cur = 1;
        int curX = r - 1;
        int curY = 0;
        int dir = 0;


        if (k > r * c) {
            return new int[]{0, 0};
        }

        while (cur < k) {
            check[curX][curY] = true;

            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || check[nx][ny]) {
                dir = (dir + 1) % 4;
            } else {
                curX = nx;
                curY = ny;
                cur++;
            }
        }

        return new int[]{curY + 1, r - curX};
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}