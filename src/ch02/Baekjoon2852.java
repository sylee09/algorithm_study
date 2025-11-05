package ch02;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon2852 {
    public static void main(String[] args) {
        //입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        // 팀:득점
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        String previousEventTime = "00:00";
        int ansInteger1 = 0;
        int ansInteger2 = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int team = Integer.parseInt(split[0]);
            String eventTime = split[1];

            // 이벤트 생길때 해시맵 value 비교후 더큰것 : 현재시간 - 이전시간
            // 저번 이벤트 시간 = 현재 이벤트 시간
            if (map.get(1) > map.get(2)) {
                String[] split1 = eventTime.split(":");
                int minuteNow = Integer.parseInt(split1[0]);
                int secondNow = Integer.parseInt(split1[1]);
                String[] split2 = previousEventTime.split(":");
                int minuteBefore = Integer.parseInt(split2[0]);
                int secondBefore = Integer.parseInt(split2[1]);

                if (secondNow < secondBefore) {
                    minuteNow -= 1;
                    secondNow += 60;
                }

                ansInteger1 += ((minuteNow - minuteBefore) * 60 + (secondNow - secondBefore));
            } else if (map.get(1) < map.get(2)) {
                String[] split1 = eventTime.split(":");
                int minuteNow = Integer.parseInt(split1[0]);
                int secondNow = Integer.parseInt(split1[1]);
                String[] split2 = previousEventTime.split(":");
                int minuteBefore = Integer.parseInt(split2[0]);
                int secondBefore = Integer.parseInt(split2[1]);

                if (secondNow < secondBefore) {
                    minuteNow -= 1;
                    secondNow += 60;
                }

                ansInteger2 += ((minuteNow - minuteBefore) * 60 + (secondNow - secondBefore));
            }

            map.put(team, map.get(team) + 1);
            previousEventTime = eventTime;
        }

        if (map.get(1) > map.get(2)) {
            int minuteNow = 48;
            int secondNow = 0;
            String[] split2 = previousEventTime.split(":");
            int minuteBefore = Integer.parseInt(split2[0]);
            int secondBefore = Integer.parseInt(split2[1]);

            if (secondNow < secondBefore) {
                minuteNow -= 1;
                secondNow += 60;
            }

            ansInteger1 += ((minuteNow - minuteBefore) * 60 + (secondNow - secondBefore));
        } else if (map.get(1) < map.get(2)) {
            int minuteNow = 48;
            int secondNow = 0;
            String[] split2 = previousEventTime.split(":");
            int minuteBefore = Integer.parseInt(split2[0]);
            int secondBefore = Integer.parseInt(split2[1]);

            if (secondNow < secondBefore) {
                minuteNow -= 1;
                secondNow += 60;
            }

            ansInteger2 += ((minuteNow - minuteBefore) * 60 + (secondNow - secondBefore));
        }

        int ansMin1 = ansInteger1 / 60;
        int ansSec1 = ansInteger1 % 60;
        if (ansMin1 < 10) {
            System.out.print("0" + ansMin1 + ":");
        }else {
            System.out.print(ansMin1+":");
        }
        if (ansSec1 < 10) {
            System.out.println("0" + ansSec1);
        } else {
            System.out.println(ansSec1);
        }

        int ansMin2 = ansInteger2 / 60;
        int ansSec2 = ansInteger2 % 60;
        if (ansMin2 < 10) {
            System.out.print("0" + ansMin2 + ":");
        }else {
            System.out.print(ansMin2+":");
        }
        if (ansSec2 < 10) {
            System.out.println("0" + ansSec2);
        } else {
            System.out.println(ansSec2);
        }
    }
}
