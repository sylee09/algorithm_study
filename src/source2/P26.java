package source2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A; i++) {
            set.add(sc.nextInt());
        }

        int B = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < B; i++) {
            int num = sc.nextInt();
            if (set.contains(num)) {
                list.add(num);
            }
        }

        list.sort((a, b) -> a.compareTo(b));

        for (int element : list) {
            System.out.print(element + " ");
        }
    }
}
