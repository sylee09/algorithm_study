package source1.ch1;


import java.util.ArrayList;
import java.util.Scanner;

public class Ch1_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        ArrayList<int[]> eventList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            line = sc.nextLine();
            split = line.split(" ");
            eventList.add(new int[]{Integer.parseInt(split[0]), 1});
            eventList.add(new int[]{Integer.parseInt(split[1]), -1});
        }

        eventList.sort((x, y) -> {
            if (x[0] < y[0]) {
                return -1;
            } else if (x[0] > y[0]) {
                return 1;
            } else if (x[1] < y[1]) {
                return -1;
            } else if (x[1] > y[1]) {
                return 1;
            }
            return 0;
        });

        int answer = 0;
        int prev = eventList.get(0)[0];
        int count = 0;

        for (int[] element : eventList) {
            int event = element[0];
            if (count == 1) {
                answer += (count * (event - prev)) * a;
            } else if (count == 2) {
                answer += (count * (event - prev)) * b;
            } else if (count == 3) {
                answer += (count * (event - prev)) * c;
            }

            prev = event;
            count += element[1];
        }

        System.out.println(answer);
    }
}
