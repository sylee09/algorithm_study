package source1.ch06;

import java.util.HashSet;
import java.util.Scanner;

public class Baekjoon1269 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        for (int i = 0; i < A; i++) {
            setA.add(sc.nextInt());
        }

        for (int i = 0; i < B; i++) {
            setB.add(sc.nextInt());
        }

        int answer = 0;

        for (int element : setA) {
            if (!setB.contains(element)) {
                answer++;
            }
        }

        for (int element : setB) {
            if (!setA.contains(element)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
