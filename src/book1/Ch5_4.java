package book1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch5_4 {

    public int[] solution(int[] answers) {
        int n = answers.length;
        int[] pattern1 = new int[]{1, 2, 3, 4, 5};
        int[] number1 = new int[n];
        for (int idx = 0; idx < n; idx++) {
            int x = idx % pattern1.length;
            number1[idx] = pattern1[x];
        }

        int[] pattern2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] number2 = new int[n];
        for (int idx = 0; idx < n; idx++) {
            int x = idx % pattern2.length;
            number2[idx] = pattern2[x];
        }

        int[] pattern3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] number3 = new int[n];
        for (int idx = 0; idx < n; idx++) {
            int x = idx % pattern3.length;
            number3[idx] = pattern3[x];
        }

        int[] correct = new int[3];
        for (int idx = 0; idx < answers.length; idx++) {
            if (answers[idx] == number1[idx]) {
                correct[0]++;
            }
            if (answers[idx] == number2[idx]) {
                correct[1]++;
            }
            if (answers[idx] == number3[idx]) {
                correct[2]++;
            }
        }

        int max = Arrays.stream(correct).max().getAsInt();

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int idx = 0; idx < 3; idx++) {
            if (correct[idx] == max) {
                answerList.add(idx + 1);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Ch5_4 solution = new Ch5_4();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 3, 2, 4, 2})));
    }
}
