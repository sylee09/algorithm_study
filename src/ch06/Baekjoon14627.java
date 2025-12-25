package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14627 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        long s = Long.parseLong(split[0]);
        long c = Long.parseLong(split[1]);
        long l = 1;
        long r = 0;

        long[] arr = new long[(int) s];
        for (int i = 0; i < s; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (r < arr[i]) {
                r = arr[i];
            }
        }
        r += 1;

        while (l < r) {
            long mid = (l + r) / 2;
            long sum = 0;
            boolean flag = false;
            for (long element : arr) {
                sum += (element / mid);
                if (sum >= c) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l -= 1;


        long total = 0;
        for (long element : arr) {
            total += element;
        }

        long answer = total - (c * l);

        System.out.println(answer);

    }
}
