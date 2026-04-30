package book1.ch5;

import java.util.Arrays;

public class Ch5_1 {

    private void solution(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        Ch5_1 solution = new Ch5_1();
        int[] arr1 = new int[]{1, -5, 2, 4, 3};
        solution.solution(arr1);
//        for (int element : arr1) {
//            System.out.print(element + " ");
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{2, 1, 1, 3, 2, 5, 4};
        solution.solution(arr2);
//        for (int element : arr2) {
//            System.out.print(element + " ");
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{6, 1, 7};
        solution.solution(arr3);
//        for (int element : arr3) {
//            System.out.print(element + " ");
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr3));

    }
}
