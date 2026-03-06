package source3;

import java.util.Arrays;

public class P4 {

    // r=5, c=6
    // [r-1,0] => [1,1]
    // [r-2,0] => [1,2]
    // [r-r,1] => [2,5]
    // 결국 [col+1, r-(row)]로 변환됨

    public int[] solution(int c, int r, int k) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int[] cur = new int[]{r - 1, 0};
        int cnt = 1;
        int dir = 0;

        boolean[][] check = new boolean[r][c];
        check[r - 1][0] = true;

        if (r * c < k) {
            return new int[]{0, 0};
        }

        while (cnt < k) {
            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || check[nx][ny]) {
                dir = (dir + 1) % 4;
                continue;
            }

            cur[0] = nx;
            cur[1] = ny;
            check[nx][ny] = true;

            cnt++;
        }

        return new int[]{cur[1] + 1, r - cur[0]};
    }

    public static void main(String[] args) {
        P4 T = new P4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}