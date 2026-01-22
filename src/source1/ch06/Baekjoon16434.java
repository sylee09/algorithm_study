package source1.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon16434 {

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        long N = Long.parseLong(split[0]);
        long ATK = Long.parseLong(split[1]);

        ArrayList<long[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            split = line.split(" ");
            long f = Long.parseLong(split[0]);
            long s = Long.parseLong(split[1]);
            long t = Long.parseLong(split[2]);
            list.add(new long[]{f, s, t});
        }

        long l = 1L;
        long r = Long.MAX_VALUE;

        while (l < r) {
            long mid = (l + r) / 2;
            if (isPossible(mid, list, ATK)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    static boolean isPossible(long hp, ArrayList<long[]> list, long ATK) {
        long curHp = hp;
        for (long[] element : list) {
            if (element[0] == 1) {
                long monsterAtk = element[1];
                long monsterHp = element[2];

                if (monsterHp <= ATK) {
                    continue;
                }

                long atkCnt = (monsterHp / ATK) + (monsterHp % ATK == 0 ? 0 : 1);
                long damage = (atkCnt - 1) * monsterAtk;

                if (damage>=curHp) {
                    return false;
                }
                curHp -= damage;
            } else {
                curHp = Math.min(curHp + element[2], hp);
                ATK += element[1];
            }
        }
        return true;
    }
}
