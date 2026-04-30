package book1.ch5;

import java.util.Arrays;
import java.util.TreeSet;

public class Ch5_2 {
    private int[] solution(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b.compareTo(a));
        for (int element : arr) {
            set.add(element);
        }

        return set.stream().mapToInt(a -> a.intValue()).toArray();
    }

    public static void main(String[] args) {
        Ch5_2 solution = new Ch5_2();
        System.out.println(Arrays.toString(solution.solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution.solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }
}
