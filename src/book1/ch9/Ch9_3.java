package book1.ch9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ch9_3 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Node> tree = new HashMap<>();
        tree.put("center", new Node("center", 0));
        for (String e : enroll) {
            tree.put(e, new Node(e, 0));
        }


        for (int idx = 0; idx < referral.length; idx++) {
            String key = enroll[idx];
            Node node = tree.get(key);

            if (referral[idx].equals("-")) {
                Node parent = tree.get("center");
                node.referral = parent;
            } else {
                Node parent = tree.get(referral[idx]);
                node.referral = parent;
            }
        }

        for (int idx = 0; idx < seller.length; idx++) {
            String s = seller[idx];
            Node node = tree.get(s);
            int original = amount[idx] * 100;

            while (node.referral != null) {
                int fee = original / 10;
                if (fee < 1) {
                    node.amount += original;
                    break;
                }
                node.amount += original - fee;
                node = node.referral;
                original = fee;
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < enroll.length; i++) {
            String key = enroll[i];
            answerList.add(tree.get(key).amount);
        }

        return answerList.stream().mapToInt(x -> x.intValue()).toArray();
    }

    static class Node {
        String name;
        int amount;
        Node referral;

        public Node(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Ch9_3 solution = new Ch9_3();
        int[] answer = solution.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});
        System.out.println(Arrays.toString(answer));
    }
}
