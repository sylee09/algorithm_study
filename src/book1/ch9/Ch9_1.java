package book1.ch9;

public class Ch9_1 {

    private static String preorder(int[] nodes, int idx) {
        if (nodes.length <= idx) {
            return "";
        }
        return nodes[idx] + " " + preorder(nodes, idx * 2) + preorder(nodes, idx * 2 + 1);
    }

    private static String inorder(int[] nodes, int idx) {
        if (nodes.length <= idx) {
            return "";
        }
        return inorder(nodes, idx * 2) + nodes[idx] + " " + inorder(nodes, idx * 2 + 1);
    }

    private static String postorder(int[] nodes, int idx) {
        if (nodes.length <= idx) {
            return "";
        }
        return postorder(nodes, idx * 2) + inorder(nodes, idx * 2 + 1) + nodes[idx] + " ";
    }

    public static void main(String[] args) {
        int[] nodes = {-1, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(preorder(nodes, 1));
        System.out.println(inorder(nodes, 1));
        System.out.println(postorder(nodes, 1));
    }
}
