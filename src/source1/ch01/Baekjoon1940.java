package source1.ch01;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon1940 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        //set에 입력과 짝이되는 값들 넣고 이 값이 입력으로 들어오면 cnt++
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int target = M - num;
            if (set.contains(num)) {
                cnt++;
                set.remove(num);
            } else {
                set.add(target);
            }
        }
        System.out.println(cnt);
    }
}
