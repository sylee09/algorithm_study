package source3.simulation;

class P6 {

    public int solution(int[][] fruit) {
        boolean[] changed = new boolean[fruit.length];

        for (int idx = 0; idx < fruit.length; idx++) {
            if (changed[idx]) {
                continue;
            }
            int min = getMin(fruit[idx]);
            if (!isMinUnique(min, fruit[idx])) {
                continue;
            }
            int minIndex1 = getMinIndex(min, fruit[idx]);

            for (int j = idx + 1; j < fruit.length; j++) {
                if (changed[j]) {
                    continue;
                }
                int min2 = getMin(fruit[j]);
                if (!isMinUnique(min2, fruit[j])) {
                    continue;
                }
                int minIndex2 = getMinIndex(min2, fruit[j]);
                if (minIndex1 == minIndex2) {
                    continue;
                }
                if (fruit[j][minIndex2] + 1 <= fruit[j][minIndex1] - 1 && fruit[idx][minIndex1] + 1 <= fruit[idx][minIndex2] - 1) {
                    if (fruit[idx][minIndex2] >= 1 && fruit[j][minIndex1] >= 1) {
                        fruit[idx][minIndex1] += 1;
                        fruit[idx][minIndex2] -= 1;
                        fruit[j][minIndex2] += 1;
                        fruit[j][minIndex1] -= 1;
                        changed[idx] = true;
                        changed[j] = true;
                        break;
                    }
                }
            }
        }

        int answer = 0;
        for (int[] f : fruit) {
            int min = getMin(f);
            answer += min;
        }
        return answer;
    }

    public boolean isMinUnique(int min, int[] fruit) {
        int cnt = 0;
        for (int f : fruit) {
            if (f == min) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int getMin(int[] fruit) {
        int min = Integer.MAX_VALUE;

        for (int f : fruit) {
            if (f < min) {
                min = f;
            }
        }
        return min;
    }

    public int getMinIndex(int min, int[] fruit) {
        int idx = 0;
        for (int f : fruit) {
            if (min == f) {
                return idx;
            }
            idx++;
        }
        return idx;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}