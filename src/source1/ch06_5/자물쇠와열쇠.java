package source1.ch06_5;

public class 자물쇠와열쇠 {

    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;

        int limitN = lock.length * 3;


        for (int d = 0; d < 4; d++) {
            rotate(key);

            // key는 0 ~ 2N-1까지 움직일수 있다.
            for (int x = 0; x < 2 * N; x++) {
                for (int y = 0; y < 2 * N; y++) {
                    int[][] newLock = new int[limitN][limitN];

                    // newLock 중앙에 lock 위치시킴
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            newLock[i + N][j + N] = lock[i][j];
                        }
                    }

                    // key와 lock 매칭하기
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }

                    if (check(N, newLock)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean check(int N, int[][] newLock) {
        for (int i = N; i < 2 * N; i++) {
            for (int j = N; j < 2 * N; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int[][] key, int[][] newLock, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                newLock[i + x][j + y] += key[i][j];
                if (newLock[i + x][j + y] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rotate(int[][] key) {
        int[][] rotated = new int[key.length][key[0].length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                rotated[j][key.length - 1 - i] = key[i][j];
            }
        }

        for (int i = 0; i < key.length; i++) {
            System.arraycopy(rotated[i], 0, key[i], 0, key.length);
        }
    }
}
