package source2;

import java.util.Scanner;

public class P9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(line);
        System.out.println(answer);
    }
}
