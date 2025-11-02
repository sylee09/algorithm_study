package ch01;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon1629 {
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long C = sc.nextInt();

        map.put(1L, A % C);
        long ans = func(A, B, C);

        System.out.println(ans);
    }

    // B가 짝수면 A^B = A^B/2 * A^B/2
    // B가 홀수면 A^B = A^B/2 * A^B/2 * A
    // 모듈러 연산 (A*B)%C => (A%C * B%C)%C
    static long func(long A, long B, long C) {
        if (map.containsKey(B)) {
            return map.get(B);
        }

        long half = func(A, B / 2, C);
        long result = (half * half) % C;
        if (B % 2 == 0) {
            map.put(B, result);
        } else {
            result = (result * (A % C)) % C;
            map.put(B, result);
        }
        return map.get(B);
    }
}
