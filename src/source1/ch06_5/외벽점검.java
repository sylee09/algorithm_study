package source1.ch06_5;

public class 외벽점검 {
    private int n;
    private int[] weak;
    private int[] dist;
    private int[] doubledWeak;
    private int minFriends;
    private boolean found = false;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        this.minFriends = Integer.MAX_VALUE;

        // 1. 원형인 weak 배열을 2배 늘려 선형으로 변환
        doubledWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            doubledWeak[i] = weak[i];
            doubledWeak[i + weak.length] = weak[i] + n;
        }

        // 2. 투입할 친구의 수를 1명부터 dist.length까지 늘려가며 확인
        for (int i = 1; i <= dist.length; i++) {
            makePermutation(i, 0, new int[i], new boolean[dist.length]);
            if(minFriends!=Integer.MAX_VALUE) break;
        }

        return minFriends == Integer.MAX_VALUE ? -1 : minFriends;
    }

    // 사용할 친구들의 순열 생성
    private void makePermutation(int count, int depth, int[] output, boolean[] visited) {
        if(found) return;
        if (depth == count) {
            check(output);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = dist[i];
                makePermutation(count, depth + 1, output, visited);
                visited[i] = false;
            }
        }
    }

    // 정해진 친구 순서로 모든 취약 지점을 점검 가능한지 확인
    private void check(int[] friendsOrder) {
        int weakCount = weak.length;

        // 모든 weak 지점을 각각 시작점으로 설정해봄
        for (int start = 0; start < weakCount; start++) {
            int friendsIdx = 0;
            // 현재 친구가 커버할 수 있는 마지막 위치
            int finishLine = doubledWeak[start] + friendsOrder[friendsIdx];

            int count = 1; // 투입된 친구 수
            boolean possible = true;

            for (int i = start; i < start + weakCount; i++) {
                // 점검 범위를 벗어난 취약 지점을 만났을 때
                if (doubledWeak[i] > finishLine) {
                    friendsIdx++; // 다음 친구 투입
                    if (friendsIdx == friendsOrder.length) {
                        possible = false;
                        break;
                    }
                    count++;
                    finishLine = doubledWeak[i] + friendsOrder[friendsIdx];
                }
            }

            if (possible) {
                minFriends = Math.min(minFriends, friendsOrder.length);
                found = true;
                return;
            }
        }
    }
}