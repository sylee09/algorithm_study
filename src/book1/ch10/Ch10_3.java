package book1.ch10;

import java.util.Arrays;
import java.util.HashSet;

public class Ch10_3 {

    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int idx = 0;
        for (int i = 0; i < words.length; i++) {
            idx = i % n;
            if (set.contains(words[i])) {
                return new int[]{idx + 1, i / n + 1};
            } else {
                set.add(words[i]);
            }
            if (i != 0 && words[i - 1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {
                return new int[]{idx + 1, i / n + 1};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Ch10_3 solution = new Ch10_3();
        System.out.println(Arrays.toString(solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "roboy", "tank"})));
        System.out.println(Arrays.toString(solution.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
