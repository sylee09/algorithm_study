package book1.ch8;

import java.util.Arrays;
import java.util.HashMap;

public class Ch8_3 {

    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int idx = 0; idx < want.length; idx++) {
            String w = want[idx];
            int n = number[idx];
            wantMap.put(w, n);
        }

        int length = Arrays.stream(number).sum();
        HashMap<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;

        if (wantMap.equals(discountMap)) {
            answer++;
        }

        for (int i = length; i < discount.length; i++) {
            String w = discount[i - length];
            discountMap.put(w, discountMap.get(w) - 1);
            if (discountMap.get(w) == 0) {
                discountMap.remove(w);
            }
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);

            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ch8_3 solution = new Ch8_3();
        int answer = solution.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println(answer);
    }
}
