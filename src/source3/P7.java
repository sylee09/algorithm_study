package source3;

import java.util.Arrays;

class P7 {
    static int[] dx = new int[]{-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};

    public int solution(int[] keypad, String password){
        int[][] dist = new int[11][11];
        for (int i = 0; i <= 10; i++) {
            Arrays.fill(dist[i], 2);
        }

        for (int i = 1; i <= 10; i++) dist[i][i] = 0;

        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = keypad[i * 3 + j];
            }
        }

        for (int k = 0; k < dx.length; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;

                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int from = arr[i][j];
                        int to = arr[nx][ny];

                        dist[from][to] = 1;
                        dist[to][from] = 1;
                    }
                }
            }
        }

        int answer = 0;
        int from = Integer.parseInt(String.valueOf(password.charAt(0)));

        for (int i = 1; i < password.length(); i++) {
            int to = Integer.parseInt(String.valueOf(password.charAt(i)));
            answer += dist[from][to];
            from = to;
        }

        return answer;

    }

    public int[] findIndex(char element, int[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == Integer.parseInt(String.valueOf(element))) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        P7 T = new P7();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}