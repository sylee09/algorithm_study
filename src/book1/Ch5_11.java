package book1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch5_11 {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();

        for (int element : arr) {
            if (element % divisor == 0) {
                list.add(element);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }
        return list.stream().mapToInt(x -> x.intValue()).toArray();
    }
}
