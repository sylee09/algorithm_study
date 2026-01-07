package ch06_5;

public class 기지국설치 {

    public int solution(int n, int[] stations, int w) {
        int cur = 1;
        int jump = 2 * w + 1;
        int answer = 0;
        int stationIdx = 0;

        while (cur <= n) {
            if (stationIdx < stations.length) {
                int l = stations[stationIdx] - w;
                int r = stations[stationIdx] + w;
                if (l <= cur && r >= cur) {
                    cur = r + 1;
                    stationIdx++;
                } else {
                    cur += jump;
                    answer++;
                }
            } else {
                cur += jump;
                answer++;
            }
        }
        return answer;
    }
}
