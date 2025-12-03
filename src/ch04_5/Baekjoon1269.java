package ch04_5;

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

        HashSet<Integer> diffA = new HashSet<>(setA);
        HashSet<Integer> diffB = new HashSet<>(setB);

        diffA.removeAll(setB);
        diffB.removeAll(setA);

        System.out.println(diffA.size() + diffB.size());
    }
}
