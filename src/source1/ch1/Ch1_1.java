package source1.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ch1_1 {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        func(new ArrayList<Integer>(), arr, 0);
    }

    private static void func(ArrayList<Integer> list, int[] arr, int start) {
        if (found) {
            return;
        }

        if (list.size() == 7) {
            int sum = 0;
            for (int element : list) {
                sum += element;
            }
            if (sum == 100) {
                for (int element : list) {
                    System.out.println(element);
                }
                found = true;
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            func(list, arr, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
