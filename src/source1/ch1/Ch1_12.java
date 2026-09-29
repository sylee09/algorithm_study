package source1.ch1;

import java.util.Arrays;
import java.util.Scanner;

public class Ch1_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int answer = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == m) {
                answer++;
                left++;
                right--;
            } else if (sum < m) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }
}
