package source1.ch1;

import java.util.Scanner;

public class Ch1_14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(recursiveFunction(a, b, c));
    }

    private static long recursiveFunction(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }

        long half = recursiveFunction(a, b / 2, c);
        long result = ((half % c) * (half % c)) % c;
        if (b % 2 == 1) {
            result = ((result % c) * (a % c)) % c;
        }
        return result;
    }
}
