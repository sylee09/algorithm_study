package source2;

import java.util.Arrays;
import java.util.Scanner;

public class P53 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long l = 1;
        long r = arr[arr.length - 1] + 1;

        while (l < r) {
            long mid = (l + r) / 2;
            if (canDo(arr, mid, C)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l - 1);
    }

    static boolean canDo(long[] arr, long mid, int C) {
        int curIdx = 0;
        long curPos = arr[0];
        int count = 1;
//        System.out.println("mid: " + mid);
        while (count < C) {
            curPos += mid;
            while (arr[curIdx] < curPos) {
                curIdx++;
                if (curIdx >= arr.length) {
                    return false;
                }
            }
            curPos = arr[curIdx];
            count++;
//            System.out.println(curPos);
        }
        return true;
    }
}
