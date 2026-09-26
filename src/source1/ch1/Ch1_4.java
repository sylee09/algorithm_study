package source1.ch1;

import java.util.Scanner;

public class Ch1_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int left = 0;
        int right = line.length() - 1;

        while (left < right) {
            if (line.charAt(left) != line.charAt(right)) {
                System.out.println(0);
                return;
            }
            left++;
            right--;
        }
        System.out.println(1);
    }
}
