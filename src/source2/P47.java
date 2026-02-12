package source2;

import java.util.LinkedList;
import java.util.Scanner;

public class P47 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (list.size() < S) {
                if (list.contains(num)) {
                    list.remove((Integer) num);
                    list.offerFirst(num);
                } else {
                    list.offerFirst(num);
                }
            } else {
                if (list.contains(num)) {
                    list.remove((Integer) num);
                    list.offerFirst(num);
                } else {
                    list.pollLast();
                    list.offerFirst(num);
                }
            }
        }

        for (int element : list) {
            System.out.print(element + " ");
        }
    }
}
