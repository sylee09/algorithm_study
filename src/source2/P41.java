package source2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P41 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i=1;i<=input1;i++){
            deque.offer(i);
        }

        int cnt = 1;
        while (!deque.isEmpty()) {
            int polled = deque.poll();
            if (cnt == input2) {
                if(deque.isEmpty()){
                    System.out.println(polled);
                    return;
                }
                cnt = 1;
            }else {
                cnt++;
                deque.offer(polled);
            }
        }
    }
}
