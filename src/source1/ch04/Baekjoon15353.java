package source1.ch04;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon15353 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        String[] numbers = nums.split(" ");
        BigInteger A = new BigInteger(numbers[0]);
        BigInteger B = new BigInteger(numbers[1]);
        BigInteger result = A.add(B);
        System.out.println(result);
    }
}
