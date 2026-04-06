package source3.simulation;


import java.util.ArrayList;

class P5 {
    public int solution(int[] nums){
        ArrayList<Integer> idxList = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                idxList.add(i);
            }
        }

        int answer = 0;
        for (int idx : idxList) {
            int left = idx - 1;
            int right = idx + 1;
            int cur = nums[idx];
            while (left >= 0 && nums[left] < cur) {
                cur = nums[left];
                left--;
            }
            cur = nums[idx];
            while (right < nums.length && nums[right] < cur) {
                cur = nums[right];
                right++;
            }
            answer = Math.max(answer, right - left - 1);
        }

        return answer;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
