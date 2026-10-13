package source1.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10709 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        int H = Integer.parseInt(tokenizer.nextToken());
        int W = Integer.parseInt(tokenizer.nextToken());

        ArrayDeque<int[]>[] deques = new ArrayDeque[H];
        for (int i = 0; i < H; i++) {
            deques[i] = new ArrayDeque<int[]>();
        }
        int[][] answer = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(answer[i], -1);
        }

        char[][] arr = new char[H][W];
        for (int i = 0; i < H; i++) {
            line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'c') {
                    deques[i].add(new int[]{i, j});
                    answer[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            if (deques[i].isEmpty()) {
                continue;
            }
            int distance = 0;
            while (!deques[i].isEmpty()) {
                int size = deques[i].size();
                for (int x = 0; x < size; x++) {
                    int[] cur = deques[i].poll();
                    int y = cur[1];
                    int ny = y + 1;

                    if (ny < W && answer[cur[0]][ny] == -1) {
                        answer[cur[0]][ny] = distance + 1;
                        deques[i].offer(new int[]{cur[0], ny});
                    }
                }
                distance++;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
