package source3;

import java.util.*;

class P5 {
    public int solution(int[] nums){
        ArrayList<Integer> peakIndex = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peakIndex.add(i);
            }
        }

        int answer = 0;

        for (int element : peakIndex) {
            int count = 1;
            int left = element - 1;
            int cur = nums[element];
            while (left >= 0 && cur > nums[left]) {
                cur = nums[left];
                left--;
                count++;
            }
            int right = element + 1;
            cur = nums[element];
            while (right < nums.length && cur > nums[right]) {
                cur = nums[right];
                right++;
                count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
