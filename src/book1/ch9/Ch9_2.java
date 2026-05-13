package book1.ch9;

public class Ch9_2 {

    public int solution(int n, int a, int b) {
        int answer = 0;
        while (Math.ceil(a / 2.0) != Math.ceil(b / 2.0)) {
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        Ch9_2 solution = new Ch9_2();
        System.out.println(solution.solution(8, 4, 7));
    }
}
