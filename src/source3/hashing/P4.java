package source3.hashing;

import java.util.HashMap;

public class P4 {

    public int solution(int[] nums, int m){
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long prefixSum = 0L;

        int answer = 0;
        for (int num : nums) {
            prefixSum += num;
            long target = prefixSum - m;

            answer += map.getOrDefault(target, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        P4 T = new P4();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
