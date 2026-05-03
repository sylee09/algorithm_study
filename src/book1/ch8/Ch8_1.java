package book1.ch8;

import java.util.HashSet;

public class Ch8_1 {

    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : arr) {
            if (set.contains(target - element)) {
                return true;
            }
            set.add(element);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }
}
