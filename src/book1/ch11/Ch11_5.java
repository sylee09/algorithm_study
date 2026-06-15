package book1.ch11;

public class Ch11_5 {

    public int solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                answer++;
                dfs(check, computers, i);
            }
        }
        return answer;
    }

    private void dfs(boolean[] check, int[][] computers, int cur) {
        if (check[cur]) {
            return;
        }
        check[cur] = true;

        for (int neighbor = 0; neighbor < computers.length; neighbor++) {
            if (computers[cur][neighbor] == 1 && !check[neighbor]) {
                dfs(check, computers, neighbor);
                check[neighbor] = true;
            }
        }
    }

    public static void main(String[] args) {
        Ch11_5 solution = new Ch11_5();
        System.out.println(solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
