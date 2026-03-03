package source2;

import java.util.ArrayList;
import java.util.Scanner;

public class P74 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int element : arr) {
            int index = findIndex(list, element);
//            System.out.println("element: " + element + " index: " + index);
            if (list.size() > index) {
                list.set(index, element);
            } else {
                list.add(element);
            }
        }

        System.out.println(list.size());
    }

    static int findIndex(ArrayList<Integer> list, int element) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= element) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
