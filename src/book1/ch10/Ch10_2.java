package book1.ch10;

import java.util.HashMap;

public class Ch10_2 {

    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int limit = nums.length / 2;

        int size = map.keySet().size();

        if (limit <= size) {
            return limit;
        }

        return size;
    }
}
