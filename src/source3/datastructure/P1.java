package source3.datastructure;


import java.util.HashSet;

public class P1 {
    public int solution(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int answer = 0;

        for (int num : set) {
            int count = 0;
            if (set.contains(num - 1)) {
                continue;
            }
            int n = num;

            while (set.contains(n)) {
                count++;
                n += 1;
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }

    public static void main(String[] args){
        P1 T = new P1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
