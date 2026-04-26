package book1;

import java.util.ArrayList;

public class Ch5_10 {
    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (long idx = left; idx <= right; idx++) {
            long r = idx / n;
            long c = idx % n;
            int num = (int) Math.max(r, c) + 1;
            list.add(num);
        }

        return list.stream().mapToInt(x -> x.intValue()).toArray();
    }
}
