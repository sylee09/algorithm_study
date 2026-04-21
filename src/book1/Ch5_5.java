package book1;

public class Ch5_5 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch5_5 solution = new Ch5_5();
        int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][]{{3, 3}, {3, 3}};
        int[][] answer1 = solution.solution(arr1, arr2);
        for (int[] ans : answer1) {
            for (int element : ans) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
        arr1 = new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        arr2 = new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        answer1 = solution.solution(arr1, arr2);
        for (int[] ans : answer1) {
            for (int element : ans) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
