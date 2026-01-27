package source2;

import java.util.Scanner;

public class P18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        String[] numbers = line.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String number : numbers) {
            String reverse = new StringBuilder(number).reverse().toString();
            int intNumber = Integer.parseInt(reverse);
            if (isPrime(intNumber)) {
                ans.append(intNumber + " ");
            }
        }
        System.out.println(ans);
    }

    static boolean isPrime(int intNumber) {
        if (intNumber == 1) {
            return false;
        }
        for (int i = 2; i * i <= intNumber; i++) {
            if (intNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
