package source1.ch1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Ch1_15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            long num = 1;
            int answer = 1;

            while (num % n != 0) {
                num = (10 * num + 1) % n;
                answer++;
            }

            System.out.println(answer);
        }
    }
}
