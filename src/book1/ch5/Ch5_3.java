package book1.ch5;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch5_3 {

    public int[] solution(int[] numbers) {
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                answerList.add(sum);
            }
        }
        answerList.sort((a, b) -> a.compareTo(b));

        return answerList.stream().mapToInt(x -> x.intValue()).distinct().toArray();
    }

    public static void main(String[] args) {
        Ch5_3 solution = new Ch5_3();
        int[] numbers = new int[]{2, 1, 3, 4, 1};

        int[] answer = solution.solution(numbers);
        System.out.println(Arrays.toString(answer));
    }
}
