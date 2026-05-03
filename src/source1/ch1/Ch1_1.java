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
//        System.out.println(Arrays.toString(arr));

        helpFunc(arr, new ArrayList<Integer>(), 0);
    }

    static void helpFunc(int[] arr, ArrayList<Integer> list, int idx) {
        if (found) {
            return;
        }
        if (list.size() == 7) {
            int sum = list.stream().mapToInt(x -> x.intValue()).sum();
            if (sum == 100) {
                found = true;
                for (int val : list) {
                    System.out.println(val);
                }
            }
            return;
        }
        for (int i = idx; i < 9; i++) {
            list.add(arr[i]);
            helpFunc(arr, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
