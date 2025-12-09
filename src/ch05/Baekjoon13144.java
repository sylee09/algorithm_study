package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon13144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        int l = 0, r = 0;
        int[] arr = new int[N];
        long answer = 0;

        String line = br.readLine();
        String[] split = line.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        while (r < N) {
            // set에 이미 숫자가 있으면
            // 그 숫자를 제거할때까지 left를 이동시킨다.
            if (set.contains(arr[r])) {
                while (true) {
                    int num = arr[l++];
                    set.remove(num);
                    if (num == arr[r]) {
                        break;
                    }
                }
            }
            // set에 추가될때마다 새로운 경우의 수만큼 answer 값을 더한다. (set의 개수만큼이 늘어남)
            set.add(arr[r]);
            answer += set.size();
            r++;
        }

        System.out.println(answer);
    }
}
