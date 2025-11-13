package ch03;

import java.util.Scanner;

public class Baekjoon9934 {

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] original = new int[(int) (Math.pow(2, K))];
        int[] inorder = new int[(int) (Math.pow(2, K)) - 1];
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = sc.nextInt();
        }

        func(inorder, 1, 0, inorder.length - 1, original);

        StringBuilder ans = new StringBuilder();
        int num = 0;
        int cnt = 0;
        // level 0의 노드수 1개
        // level 1의 노드수 2개
        // level n의 노드수 2^n 개
        for (int i = 1; i < original.length; i++) {
            ans.append(original[i] + " ");
            cnt++;
            if ((int) (Math.pow(2, num)) == cnt) {
                ans.append("\n");
                num++;
                cnt = 0;
            }
        }
        System.out.println(ans);
    }

    // 완전 이진 트리에서 왼쪽 자식의 idx는 부모의 idx*2, 오른쪽 자식의 idx = 부모의 idx*2+1
    // 루트의 노드를 1로 고정해놓고 시작
    static void func(int[] inorder,int idx, int left, int right, int[] original) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        original[idx] = inorder[mid];
        func(inorder, idx * 2, left, mid - 1, original);
        func(inorder, idx * 2 + 1, mid + 1, right, original);
    }
}
