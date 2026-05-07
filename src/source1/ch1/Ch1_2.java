package source1.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ch1_2 {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        for (char ch : string.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
