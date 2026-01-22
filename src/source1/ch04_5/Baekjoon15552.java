package source1.ch04_5;

import java.io.*;

public class Baekjoon15552 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);
            bw.append(A + B + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
