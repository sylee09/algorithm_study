package book1.ch9;


import java.util.Arrays;

public class Ch9_6 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 1L;
        long h = (long) times[times.length - 1] * n;

        while (l < h) {
            long mid = (l + h) / 2;
            if (possible(times, mid, n)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static boolean possible(int[] times, long mid, int n) {
        long cnt = 0;
        for (int t : times) {
            cnt += mid / t;
        }
        return cnt >= (long) n;
    }

    public static void main(String[] args) {
        Ch9_6 solution = new Ch9_6();
        System.out.println(solution.solution(6, new int[]{7, 10}));
    }
}
